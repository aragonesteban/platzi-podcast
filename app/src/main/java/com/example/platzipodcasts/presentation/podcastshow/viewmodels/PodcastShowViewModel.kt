package com.example.platzipodcasts.presentation.podcastshow.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import com.example.platzipodcasts.domain.models.Episode
import com.example.platzipodcasts.presentation.podcastshow.uistate.PodcastShowUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PodcastShowViewModel @Inject constructor(
    private val showsRepository: ShowsRepository,
    pager: Pager<Int, Episode>
) : ViewModel() {

    private val _uiState = MutableStateFlow(PodcastShowUiState())
    val uiState: StateFlow<PodcastShowUiState> = _uiState

    var episodesList = pager.flow.cachedIn(viewModelScope).flowOn(Dispatchers.IO)

    fun getShowDetailById(showId: Int) {
        viewModelScope.launch {
            showsRepository.getShowById(showId)
                .onStart { _uiState.value = PodcastShowUiState(isLoading = true) }
                .catch { _uiState.value = PodcastShowUiState(isError = true) }
                .collect {
                    _uiState.value = _uiState.value.copy(showDetail = it, isLoading = false)
                }
        }
    }

}