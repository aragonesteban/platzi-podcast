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

    private val _uiState = MutableStateFlow(PodcastShowUiState())
    val uiState: StateFlow<PodcastShowUiState> = _uiState

    private var nextUrl: String = ""

    fun getShowDetailById(showId: Int) {
        viewModelScope.launch {
            showsRepository.getShowById(showId)
                .onStart { _uiState.value = PodcastShowUiState(isLoading = true) }
                .catch { _uiState.value = PodcastShowUiState(isError = true)  }
                .collect {
                    _uiState.value = _uiState.value.copy(showDetail = it, isLoading = false)
                }
        }
    }

    fun getEpisodesByShowId(showId: Int) {
        viewModelScope.launch {
            episodesRepository.getEpisodesByShowId(showId)
                .onStart { _uiState.value = PodcastShowUiState(isLoading = true) }
                .catch { _uiState.value = PodcastShowUiState(isError = true) }
                .collect{
                    nextUrl = it.nextUrl
                    _uiState.value =
                        _uiState.value.copy(episodes = it.episodesList, isLoading = false)
                }
        }
    }

    fun getMoreEpisodes() {
        viewModelScope.launch {
            nextUrl.takeIf { it.isNotBlank() }?.let { url ->
                episodesRepository.getEpisodesByUrl(url)
                    .collect { result ->
                        nextUrl = result.nextUrl
                        _uiState.value = _uiState.value.copy(episodes = _uiState.value.episodes + result.episodesList)
                    }
            }
        }
    }
}