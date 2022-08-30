package com.learn.nyNews.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
abstract class BaseTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private lateinit var openMocks: AutoCloseable

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        openMocks = MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
        openMocks.close()
    }

}