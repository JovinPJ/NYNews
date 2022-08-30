package com.learn.nyNews.ui.home

import com.learn.nyNews.domain.model.Article

fun interface NewsItemClickListener {
    fun onClick(article: Article)
}