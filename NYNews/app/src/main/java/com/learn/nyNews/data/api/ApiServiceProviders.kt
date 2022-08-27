package com.learn.nyNews.data.api

import com.learn.nyNews.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(): Retrofit {
    val client = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        client.addInterceptor(logging)
    }

    return Retrofit.Builder().client(client.build())
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideNyNewsApi(retrofit: Retrofit): NyNewsApi = retrofit.create(NyNewsApi::class.java)