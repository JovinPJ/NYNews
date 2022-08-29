package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.data.api.NyNewsApi
import com.learn.nyNews.data.api.convertToDomain
import com.learn.nyNews.data.api.models.mostViewed.ResultList
import com.learn.nyNews.data.api.performApiCall
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.model.DataResult
import com.learn.nyNews.domain.repositories.NyNewsCacheRepository
import com.learn.nyNews.domain.repositories.NyNewsRepository
import javax.inject.Inject

class NyNewsRepositoryImpl @Inject constructor(
    private val newsApi: NyNewsApi,
    private val newsCacheRepository: NyNewsCacheRepository,
) : NyNewsRepository {

    override suspend fun fetchMostViewedNyNews(): DataResult<List<Article>> {
        return performApiCall {
            newsApi.getMostViewed()
        }.convertToDomain(onSuccess = {
            val articles = convertToArticles(it)
            newsCacheRepository.cacheArticles(articles)
            articles
        }, onFailure = {
            newsCacheRepository.fetchRecentArticles()
        })
    }

    private fun convertToArticles(resultList: ResultList?): List<Article> {
        val articleList: ArrayList<Article> = arrayListOf()
        var mediaUrl: String? = null
        resultList?.results?.forEach { result ->
            if (result.title != null && result.title.isNotEmpty()) {
                try {
                    mediaUrl = result.media?.get(0)?.media_metadata?.get(0)?.url
                } catch (e: Exception) {
                }
                articleList.add(
                    Article(
                        result.title,
                        result.abstract,
                        result.byline,
                        mediaUrl,
                        result.published_date
                    )
                )
            }
        }
        return articleList
    }
}