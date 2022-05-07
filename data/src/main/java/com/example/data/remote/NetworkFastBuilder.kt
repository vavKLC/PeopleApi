package com.example.data.remote

import com.example.data.BuildConfig.BASE_URL
import com.example.data.remote.apiservice.PeopleApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(
            when{
                else -> HttpLoggingInterceptor.Level.NONE
            }
        )

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun providePeopleApiService(): PeopleApiService = retrofit.create(PeopleApiService::class.java)
}