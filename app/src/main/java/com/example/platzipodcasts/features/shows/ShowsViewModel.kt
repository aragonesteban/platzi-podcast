package com.example.platzipodcasts.features.shows

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
class ShowsViewModel @Inject constructor(
    private val showsRepository: ShowsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ShowsUiState>(ShowsUiState.Loading)
    val uiState: StateFlow<ShowsUiState> = _uiState

    init {
        getPodcastShows()
    }

    private fun getPodcastShows() {
        viewModelScope.launch {
            showsRepository.getShows()
                .collect {
                    _uiState.value = when (it) {
                        is NetworkResult.Success -> ShowsUiState.ShowPodcastShows(it.data)
                        is NetworkResult.Error -> ShowsUiState.Error
                    }
                }
        }
    }
}