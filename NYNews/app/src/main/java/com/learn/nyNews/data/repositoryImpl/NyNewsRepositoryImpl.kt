package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.data.api.NyNewsApi
import com.learn.nyNews.data.api.convertToDomain
import com.learn.nyNews.data.api.models.mostViewed.ResultList
import com.learn.nyNews.data.api.performApiCall
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.model.DataResult
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
            newsCacheRepository.fetchMostViewedArticles()
        })
    }

    override suspend fun fetchNyNews(id: String): Article {
        return newsCacheRepository.fetchArticle(id)
    }

    private fun convertToArticles(resultList: ResultList?): List<Article> {
        val articleList: ArrayList<Article> = arrayListOf()
        resultList?.results?.forEach { result ->
            if (result.title != null && result.title.isNotEmpty()) {
                val mediaUrl = try {
                    result.media?.get(0)?.media_metadata?.get(0)?.url
                } catch (e: Exception) {
                    null
                }
                articleList.add(
                    Article(
                        result.title,
                        result.abstract,
                        result.byline,
                        mediaUrl,
                        result.published_date,
                        result.url
                    )
                )
            }
        }
        return articleList
    }
}