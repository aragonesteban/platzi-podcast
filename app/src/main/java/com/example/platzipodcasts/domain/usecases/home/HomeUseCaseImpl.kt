package com.example.platzipodcasts.domain.usecases.home

import com.example.platzipodcasts.data.repository.episodes.EpisodesRepository
import com.example.platzipodcasts.data.repository.shows.ShowsRepository
import com.example.platzipodcasts.domain.models.ContentHomeUi
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class HomeUseCaseImpl @Inject constructor(
    private val showsRepository: ShowsRepository,
    private val episodesRepository: EpisodesRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HomeUseCase {

    override suspend fun getContentHome(): ContentHomeUi {
        coroutineScope {
            launch {
                val shows = async { showsRepository.getShows() }.await()
                val episodes = async { episodesRepository.getEpisodes() }.await()

                ContentHomeUi(
                    shows,
                    episodes
                )
            }
        }
    }

}