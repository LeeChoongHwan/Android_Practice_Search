package com.example.android_practice_search.retrofit

import com.example.android_practice_search.constants.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val apiService: RetrofitInterface get() = instance.create(RetrofitInterface::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder().baseUrl(Constants.KAKAO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
}