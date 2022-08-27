package com.learn.nyNews.domain.usecases

import com.learn.nyNews.domain.repositories.NyNewsRepository
import javax.inject.Inject

class FetchMostViewedNyNewsUsecase @Inject constructor(private val nyNewsRepository: NyNewsRepository) {

    suspend operator fun invoke(): List<String> {
        return nyNewsRepository.fetchMostViewedNyNews()
    }
}