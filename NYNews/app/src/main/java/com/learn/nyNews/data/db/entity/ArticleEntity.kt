package com.learn.nyNews.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Article")
data class ArticleEntity(
    @PrimaryKey
    val title: String,
    val description: String?,
    val by: String?,
    val url: String?,
    val dateStr: String?
)
