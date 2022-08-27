package com.learn.nyNews.domain.repositories

interface NyNewsRepository {

    fun fetchMostViewedNyNews(): List<String>

}