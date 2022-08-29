package com.learn.nyNews.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learn.nyNews.data.db.dao.ArticleDao
import com.learn.nyNews.data.db.entity.ArticleEntity


@Database(entities = [ArticleEntity::class], version = 1)
abstract class NyNewsAppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}