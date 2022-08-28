package com.learn.nyNews.domain.usecases

import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.model.DataResult
import com.learn.nyNews.domain.repositories.NyNewsRepository
import javax.inject.Inject

class FetchMostViewedNyNewsUsecase @Inject constructor(private val nyNewsRepository: NyNewsRepository) {

    suspend operator fun invoke(): DataResult<List<Article>> {
        return nyNewsRepository.fetchMostViewedNyNews()
    }
}