package com.example.platzipodcasts.domain.usecases.home

import com.example.platzipodcasts.domain.models.ContentHomeUi

interface HomeUseCase {
    suspend fun getContentHome(): ContentHomeUi
}