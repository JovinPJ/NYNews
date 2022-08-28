package com.learn.nyNews.domain.model

sealed class DataResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataResult<T>()
    data class Failure(val error: ApiError) : DataResult<Nothing>()
}
