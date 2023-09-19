package com.example.android_practice_search.retrofit

import com.example.android_practice_search.constants.KakaoKey
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetWorkInterface {
    @Headers("Authorization: ${KakaoKey.AUTH_HEADER}")
    @GET("v2/search/image")
    suspend fun getImages(
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ): Image
}