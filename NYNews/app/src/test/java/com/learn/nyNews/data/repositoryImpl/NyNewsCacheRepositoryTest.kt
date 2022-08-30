package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.base.BaseTest
import com.learn.nyNews.data.db.dao.ArticleDao
import com.learn.nyNews.data.db.entity.ArticleEntity
import com.learn.nyNews.domain.model.Article
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class NyNewsCacheRepositoryTest : BaseTest() {


    @Mock
    lateinit var articleDao: ArticleDao

    @InjectMocks
    lateinit var nyNewsCacheRepository: NyNewsCacheRepository

    @Test
    fun cacheArticles() = runBlocking {
        //Given
        val title = "r"
        val articles = listOf(Article(title))

        //When
        nyNewsCacheRepository.cacheArticles(articles)

        //Then
        verify(articleDao, atLeastOnce()).deleteAll()
        verify(articleDao, atLeastOnce()).insertAllArticles(any())
    }

    @Test
    fun fetchMostViewedArticles(): Unit = runBlocking {

        //Given
        articleDao.stub {
            onBlocking { fetchAllArticles() } doReturn listOf(
                ArticleEntity(
                    "tt",
                    null,
                    null,
                    null,
                    null,
                    null
                )
            )
        }

        //When
        nyNewsCacheRepository.fetchMostViewedArticles()

        //Then
        verify(articleDao, atLeastOnce()).fetchAllArticles()

    }

    @Test
    fun fetchArticle(): Unit = runBlocking {
        //Given
        val title = "tt"
        articleDao.stub {
            onBlocking { fetchArticle(title) } doReturn ArticleEntity(
                "tt",
                null,
                null,
                null,
                null,
                null
            )
        }

        //When
        nyNewsCacheRepository.fetchArticle(title)

        //Then
        verify(articleDao, atLeastOnce()).fetchArticle(title)

    }
}