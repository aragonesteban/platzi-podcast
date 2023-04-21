package com.example.platzipodcasts.features.podcastshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PodcastShowViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository,
    private val showsRepository: ShowsRepository
) : ViewModel() {



    init {
        getEpisodesByShowId()
    }

    private fun getEpisodesByShowId() {
        viewModelScope.launch {
            showsRepository.getShowById()
        }
    }

}