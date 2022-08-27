package com.learn.nyNews.domain.repositories

interface NyNewsRepository {

    suspend fun fetchMostViewedNyNews(): List<String>

}