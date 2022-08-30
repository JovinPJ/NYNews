package com.learn.nyNews.ui.detail

import com.learn.nyNews.base.BaseTest
import com.learn.nyNews.domain.model.Article
import com.learn.nyNews.domain.usecases.FetchNyNewsUsecase
import com.learn.nyNews.util.getOrAwaitValue
import com.nhaarman.mockitokotlin2.atLeastOnce
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class NewsDetailViewModelTest : BaseTest() {

    @Mock
    lateinit var fetchNyNewsUsecase: FetchNyNewsUsecase

    @InjectMocks
    lateinit var newsDetailViewModel: NewsDetailViewModel

    @Test
    fun `check getArticle value is null first`() {

        Assert.assertNull(newsDetailViewModel.getArticle().value)

    }

    @Test
    fun fetchNyNews(): Unit = runBlocking {
        //Given
        val title = "df"
        val id = "id"
        fetchNyNewsUsecase.stub {
            onBlocking { invoke(id) } doReturn Article(title)
        }

        //When
        newsDetailViewModel.fetchNyNews(id)

        //Then
        val article = newsDetailViewModel.getArticle().getOrAwaitValue()
        assertNotNull(article)
        assertEquals(title, article.title)
        verify(fetchNyNewsUsecase, atLeastOnce()).invoke(id)

    }

}