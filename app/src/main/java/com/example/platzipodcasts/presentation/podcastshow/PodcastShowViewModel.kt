package com.example.platzipodcasts.presentation.podcastshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.domain.models.Episodes
import com.example.platzipodcasts.domain.models.ShowDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

typealias ContentPodcastShow<ShowDetail, Episodes> = Pair<ShowDetail, Episodes>

@HiltViewModel
class PodcastShowViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository,
    private val showsRepository: ShowsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<PodcastShowUiState>(PodcastShowUiState.Loading)
    val uiState: StateFlow<PodcastShowUiState> = _uiState

    private var episodes: Episodes? = null
    private var showDetail: ShowDetail? = null

    fun getEpisodesByShowId(showId: Int) {
        viewModelScope.launch {
            combine(
                showsRepository.getShowById(showId),
                episodesRepository.getEpisodesByShowId(showId),
            ) { showDetail, episodes ->
                ContentPodcastShow(showDetail, episodes)
            }
                .onStart { _uiState.value = PodcastShowUiState.Loading }
                .catch { _uiState.value = PodcastShowUiState.Error }
                .collect { contentPodcastShow ->
                    episodes = contentPodcastShow.second
                    showDetail = contentPodcastShow.first
                    _uiState.value = PodcastShowUiState.ShowContentPodcastShow(
                        showDetail = contentPodcastShow.first,
                        episodes = contentPodcastShow.second.episodesList
                    )
                }
        }
    }

    fun getMoreEpisodes() {
        viewModelScope.launch {
            episodes = episodes?.apply {
                nextUrl.takeIf { true }?.let { url ->
                    episodesRepository.getEpisodesByUrl(url)
                        .catch { _uiState.value = PodcastShowUiState.Error }
                        .collect { result ->
                            nextUrl = result.nextUrl
                            episodesList = episodes?.episodesList.orEmpty() + result.episodesList
                            _uiState.value =
                                PodcastShowUiState.ShowContentPodcastShow(
                                    showDetail = showDetail,
                                    episodes = episodesList
                                )
                        }
                }
            }
        }
    }

}