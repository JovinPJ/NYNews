package com.learn.nyNews.di.modules

import com.learn.nyNews.data.api.provideNyNewsApi
import com.learn.nyNews.data.api.provideRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNyNewsClient() = provideRetrofit()

    @Singleton
    @Provides
    fun provideNyNewsService(retrofit: Retrofit) = provideNyNewsApi(retrofit)
}