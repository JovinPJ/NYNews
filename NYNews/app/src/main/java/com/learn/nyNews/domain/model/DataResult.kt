package com.learn.nyNews.domain.model

sealed class DataResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataResult<T>()
    data class Failure<out T : Any>(val error: ApiError, val cachedData: T? = null) :
        DataResult<T>()
}
