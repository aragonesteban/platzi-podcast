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

@HiltViewModel
class PodcastShowViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository,
    private val showsRepository: ShowsRepository,
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<PodcastShowUiState>(PodcastShowUiState.LoadingShowDetail)
    val uiState: StateFlow<PodcastShowUiState> = _uiState

    private var episodes: Episodes? = null
    private var showDetail: ShowDetail? = null

    fun getShowDetailById(showId: Int) {
        viewModelScope.launch {
            showsRepository.getShowById(showId)
                .onStart { _uiState.value = PodcastShowUiState.LoadingShowDetail }
                .catch { _uiState.value = PodcastShowUiState.Error }
                .collect {
                    _uiState.value = PodcastShowUiState.ShowContentShowDetail(data = it)
                }
        }
    }

    fun getEpisodesByShowId(showId: Int) {
        viewModelScope.launch {
            episodesRepository.getEpisodesByShowId(showId)
                .onStart { _uiState.value = PodcastShowUiState.LoadingEpisodes }
                .catch { _uiState.value = PodcastShowUiState.Error }
                .collect {
                    _uiState.value = PodcastShowUiState.ShowEpisodes(data = it.episodesList)
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
                        }
                }
            }
        }
    }

}