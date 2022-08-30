package com.learn.nyNews.ui.home

import com.learn.nyNews.domain.model.ApiError
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.model.DataResult
import com.learn.nyNews.domain.usecases.FetchMostViewedNyNewsUsecase
import com.learn.nyNews.ui.base.BaseViewModelTest
import com.learn.nyNews.util.getOrAwaitValue
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class NewsViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var fetchMostViewedNyNewsUsecase: FetchMostViewedNyNewsUsecase

    @InjectMocks
    lateinit var newsViewModel: NewsViewModel

    @Test
    fun `test success scenario on fetchMostViewedNyNews`() = runBlocking {
        //Given
        val title = "df"
        fetchMostViewedNyNewsUsecase.stub {
            onBlocking { invoke() } doReturn DataResult.Success(listOf(Article(title)))
        }

        ///When
        val list = newsViewModel.fetchMostViewedNyNews().getOrAwaitValue()

        //Then
        assertTrue(list.isNotEmpty())
        assertEquals(1, list.size)
        assertEquals(title, list[0].title)
    }

    @Test
    fun `test failure scenario on fetchMostViewedNyNews`() = runBlocking {
        //Given
        val title = "df"
        fetchMostViewedNyNewsUsecase.stub {
            onBlocking { invoke() } doReturn DataResult.Failure(ApiError(1), listOf(Article(title)))

        }

        ///When
        val list = newsViewModel.fetchMostViewedNyNews().getOrAwaitValue()

        //Then
        assertTrue(list.isNotEmpty())
        assertEquals(1, list.size)
        assertEquals(title, list[0].title)
    }
}