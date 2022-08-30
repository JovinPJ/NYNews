package com.learn.nyNews.domain.model

data class Article(
    val title: String,
    val description: String? = null,
    val by: String? = null,
    val mediaUrl: String? = null,
    val dateStr: String? = null,
    val articleUrl: String? = null
)
