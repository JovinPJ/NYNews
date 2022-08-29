package com.learn.nyNews.domain.model

data class Article(
    val title: String,
    val description: String? = null,
    val by: String? = null,
    val url: String? = null,
    val dateStr: String? = null
)
