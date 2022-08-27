package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.data.api.NyNewsApi
import com.learn.nyNews.domain.repositories.NyNewsRepository
import javax.inject.Inject

class NyNewsRepositoryImpl @Inject constructor(private val newsApi: NyNewsApi) : NyNewsRepository {
    override suspend fun fetchMostViewedNyNews(): List<String> {
        newsApi.getMostViewed().toString()
        return listOf("dfg", "dfgdg", "dfgd")
    }
}