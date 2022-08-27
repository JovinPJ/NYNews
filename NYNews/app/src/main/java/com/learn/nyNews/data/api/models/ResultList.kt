package com.learn.nyNews.data.api.models

data class ResultList(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)