package com.learn.nyNews.domain.model

const val ERROR_CODE_UNKNOWN = -1
const val ERROR_CODE_NETWORK = 100
const val ERROR_CODE_SERVER = 101

data class ApiError(
    val errorCode: Int,
    val errorMessage: String? = null,
    val throwable: Throwable? = null
)