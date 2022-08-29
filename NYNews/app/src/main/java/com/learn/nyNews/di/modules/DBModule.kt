package com.learn.nyNews.di.modules

import android.content.Context
import com.learn.nyNews.data.db.NyNewsAppDatabase
import com.learn.nyNews.data.db.dao.ArticleDao
import com.learn.nyNews.data.db.provideNyNewsRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideDBClient(@ApplicationContext context: Context) = provideNyNewsRoomDatabase(context)

    @Singleton
    @Provides
    fun provideArticleDao(nyNewsDB: NyNewsAppDatabase): ArticleDao {
        return nyNewsDB.articleDao()
    }
}