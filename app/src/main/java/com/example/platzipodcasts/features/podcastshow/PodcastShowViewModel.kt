package com.example.platzipodcasts.features.podcastshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
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
                    _uiState.value = PodcastShowUiState.ShowContentPodcastShow(
                        showDetail = contentPodcastShow.first,
                        episodes = contentPodcastShow.second
                    )
                }
        }
    }

}