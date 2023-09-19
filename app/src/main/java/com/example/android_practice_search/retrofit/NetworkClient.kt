package com.example.android_practice_search.retrofit

import com.example.android_practice_search.constants.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkClient {
        val baseUrl = Constants.KAKAO_BASE_URL

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()

        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    private val imageRetrofit = Retrofit.Builder()
        .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(
            createOkHttpClient()
        ).build()

    val imageNetwork: NetWorkInterface = imageRetrofit.create(NetWorkInterface::class.java)
}