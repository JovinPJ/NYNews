package com.learn.nyNews.di.modules

import com.learn.nyNews.data.repositoryImpl.NyNewsCacheRepositoryImpl
import com.learn.nyNews.data.repositoryImpl.NyNewsRepositoryImpl
import com.learn.nyNews.domain.repositories.NyNewsCacheRepository
import com.learn.nyNews.domain.repositories.NyNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNyNewsRepo(nyNewsRepositoryImpl: NyNewsRepositoryImpl): NyNewsRepository

    @Binds
    abstract fun bindNyNewsCacheRepo(nyNewsCacheRepositoryImpl: NyNewsCacheRepositoryImpl): NyNewsCacheRepository
}