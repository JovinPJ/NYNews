package com.learn.nyNews.domain.repositories

import com.learn.nyNews.domain.model.Article

interface NyNewsCacheRepository {

    suspend fun cacheArticles(articles: List<Article>)
    suspend fun fetchRecentArticles(): List<Article>
    suspend fun fetchArticle(title: String): Article


}