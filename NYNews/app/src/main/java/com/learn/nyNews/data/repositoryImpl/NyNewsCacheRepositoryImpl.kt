package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.data.db.dao.ArticleDao
import com.learn.nyNews.data.db.entity.ArticleEntity
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.repositories.NyNewsCacheRepository
import javax.inject.Inject

class NyNewsCacheRepositoryImpl @Inject constructor(private val articleDao: ArticleDao) :
    NyNewsCacheRepository {

    override suspend fun cacheArticles(articles: List<Article>) {
        articleDao.deleteAll()
        articleDao.insertAllArticles(articles.map { it.toArticleEntity() })
    }

    override suspend fun fetchRecentArticles(): List<Article> {
        return articleDao.fetchAllArticles().map { it.toArticle() }
    }

    override suspend fun fetchArticle(title: String): Article {
        return articleDao.fetchArticle(title).toArticle()
    }


    private fun ArticleEntity.toArticle(): Article {
        return Article(title, description, by, url, dateStr)
    }

    private fun Article.toArticleEntity(): ArticleEntity {
        return ArticleEntity(title, description, by, url, dateStr)
    }

}