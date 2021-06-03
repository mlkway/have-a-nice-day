package com.raywenderlich.home_challenge.network


import com.raywenderlich.home_challenge.data.DomusItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("news")
    suspend fun getRequest(): List<DomusItem>

    @GET("{path}")
    suspend fun getPagingRequest(@Path("path") path: String,@Query("page") query: Int): List<DomusItem>

}