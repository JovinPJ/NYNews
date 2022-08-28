package com.learn.nyNews.data.api

import com.learn.nyNews.BuildConfig
import com.learn.nyNews.data.api.models.mostViewed.ResultList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NyNewsApi {
    @GET("mostviewed/{section}/{period}.json")
    suspend fun getMostViewed(
        @Path("section") section: String = "all-sections",
        @Path("period") period: String = "7",
        @Query("api-key") api_key: String = BuildConfig.API_KEY
    ): Response<ResultList>
}