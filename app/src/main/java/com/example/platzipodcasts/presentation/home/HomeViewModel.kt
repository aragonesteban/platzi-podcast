package com.example.platzipodcasts.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

typealias ContentHome<Shows, Episodes> = Pair<Shows, Episodes>

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val showsRepository: ShowsRepository,
    private val episodesRepository: EpisodesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getContentHome()
    }

    private fun getContentHome() {
        viewModelScope.launch {
            combine(
                showsRepository.getShows(),
                episodesRepository.getEpisodes()
            ) { shows, episodes ->
                ContentHome(shows, episodes)
            }
                .onStart { _uiState.value = HomeUiState.Loading }
                .catch { _uiState.value = HomeUiState.Error }
                .collect { contentHome ->
                    _uiState.value = HomeUiState.ShowContentHome(
                        showsCarouselList = contentHome.first,
                        episodesList = contentHome.second.take(4),
                    )
                }
        }
    }

}