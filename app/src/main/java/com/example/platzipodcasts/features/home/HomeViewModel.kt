package com.example.platzipodcasts.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzipodcasts.data.repository.remote.NetworkResult
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val showsRepository: ShowsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getPodcastShows()
    }

    private fun getPodcastShows() {
        viewModelScope.launch {
            showsRepository.getShows()
                .collect {
                    _uiState.value = when (it) {
                        is NetworkResult.Success -> HomeUiState.ShowPodcastHome(
                            podcastShowCarousel = it.data.take(3),
                            podcastShowGrid = it.data.takeLast(3)
                        )
                        is NetworkResult.Error -> HomeUiState.Error
                    }
                }
        }
    }
}