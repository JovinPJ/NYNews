package com.learn.nyNews.data.repositoryImpl

import com.learn.nyNews.base.BaseTest
import com.learn.nyNews.data.api.NyNewsApi
import com.learn.nyNews.data.api.models.mostViewed.ResultList
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class NyNewsRepositoryImplTest : BaseTest() {


    @Mock
    lateinit var newsApi: NyNewsApi

    @Mock
    lateinit var cacheRepository: NyNewsCacheRepository

    @InjectMocks
    lateinit var nyNewsRepositoryImpl: NyNewsRepositoryImpl

    @Test
    fun fetchMostViewedNyNews(): Unit = runBlocking {
        //Given

        //When
        nyNewsRepositoryImpl.fetchMostViewedNyNews()

        //Then
        verify(newsApi, atLeastOnce()).getMostViewed()
        verify(cacheRepository, atLeastOnce()).fetchMostViewedArticles()

    }

    @Test
    fun `fetchMostViewedNyNews on Success`(): Unit = runBlocking {
        //Given
        newsApi.stub {
            onBlocking { getMostViewed() } doReturn Response.success(
                ResultList(
                    null,
                    null,
                    null,
                    null
                )
            )
        }

        //When
        nyNewsRepositoryImpl.fetchMostViewedNyNews()

        //Then
        verify(newsApi, atLeastOnce()).getMostViewed()
        verify(cacheRepository, atLeastOnce()).cacheArticles(any())

    }


    @Test
    fun fetchNyNews(): Unit = runBlocking {
        //Given
        val id = "id"

        //When
        nyNewsRepositoryImpl.fetchNyNews(id)

        //Then
        verify(cacheRepository, atLeastOnce()).fetchArticle(id)
    }
}