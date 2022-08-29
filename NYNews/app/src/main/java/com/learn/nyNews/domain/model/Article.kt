package com.learn.nyNews.domain.model

data class Article(
    val title: String,
    val description: String?,
    val by: String?,
    val url: String?,
    val dateStr: String?
)
