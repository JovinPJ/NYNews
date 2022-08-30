package com.learn.nyNews.di.modules

import com.learn.nyNews.domain.repositories.NyNewsRepository
import com.learn.nyNews.domain.usecases.FetchMostViewedNyNewsUsecase
import com.learn.nyNews.domain.usecases.FetchNyNewsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideMostViewedNyNewsUseCase(nyNewsRepository: NyNewsRepository) =
        FetchMostViewedNyNewsUsecase(nyNewsRepository)

    @Provides
    fun provideNyNewsUseCase(nyNewsRepository: NyNewsRepository) =
        FetchNyNewsUsecase(nyNewsRepository)
}