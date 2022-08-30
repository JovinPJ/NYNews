package com.learn.nyNews.domain.repositories

import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.model.DataResult

interface NyNewsRepository {

    suspend fun fetchMostViewedNyNews(): DataResult<List<Article>>
    suspend fun fetchNyNews(id: String): Article

}