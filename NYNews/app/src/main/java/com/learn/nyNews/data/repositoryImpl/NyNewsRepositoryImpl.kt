package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.domain.repositories.NyNewsRepository
import javax.inject.Inject

class NyNewsRepositoryImpl @Inject constructor() : NyNewsRepository {
    override fun fetchMostViewedNyNews(): List<String> {
        return listOf("dfg", "dfgdg", "dfgd")
    }
}