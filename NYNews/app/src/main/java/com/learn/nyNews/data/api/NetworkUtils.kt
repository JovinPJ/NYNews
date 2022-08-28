package com.learn.nyNews.data.api

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.MalformedJsonException
import com.learn.nyNews.data.api.models.ErrorData
import com.learn.nyNews.domain.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

suspend fun <T : Any> performApiCall(networkApiCall: suspend () -> Response<T>): DataResult<T> {

    return try {
        withContext(Dispatchers.IO) {
            val response = networkApiCall()
            if (response.isSuccessful) {
                response.body()?.let { DataResult.Success(it) } ?: DataResult.Failure(
                    ApiError(
                        ERROR_CODE_SERVER, "Api call Successful, but empty response body"
                    )
                )
            } else {
                DataResult.Failure(ApiError(ERROR_CODE_UNKNOWN, getErrorMsg(response)))
            }
        }
    } catch (e: Exception) {
        getErrorResultData(e)
    }

}

private fun <T : Any> getErrorResultData(throwable: Throwable): DataResult<T> {
    return when (throwable) {
        is JsonParseException, is MalformedJsonException -> {
            DataResult.Failure(ApiError(ERROR_CODE_SERVER, throwable = throwable))
        }
        is IOException -> {
            DataResult.Failure(ApiError(ERROR_CODE_NETWORK, throwable = throwable))
        }
        else -> {
            DataResult.Failure(ApiError(ERROR_CODE_UNKNOWN, throwable = throwable))
        }
    }
}

private fun <T : Any> getErrorMsg(
    response: Response<T>
): String? {
    val type = object : TypeToken<ErrorData>() {}.type
    val errorResponse: ErrorData? =
        Gson().fromJson(response.errorBody()?.charStream(), type)
    return errorResponse?.fault?.faultstring
}

fun <T : Any, R : Any> DataResult<T>.convertToDomain(convert: (T) -> R): DataResult<R> {
    return when (this) {
        is DataResult.Success -> {
            DataResult.Success(convert(data))
        }
        is DataResult.Failure -> {
            DataResult.Failure(error)
        }
    }
}