package com.learn.nyNews.domain.usecases

import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.repositories.NyNewsRepository
import javax.inject.Inject

class FetchNyNewsUsecase @Inject constructor(private val nyNewsRepository: NyNewsRepository) {

    suspend operator fun invoke(id: String): Article {
        return nyNewsRepository.fetchNyNews(id)
    }
}