package com.learn.nyNews.data.db

import android.content.Context
import androidx.room.Room
import com.learn.nyNews.data.db.DBConstants.DB_NAME

fun provideNyNewsRoomDatabase(context: Context): NyNewsAppDatabase {
    return Room.databaseBuilder(context, NyNewsAppDatabase::class.java, DB_NAME)
        .build()
}