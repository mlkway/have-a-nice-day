package com.raywenderlich.home_challenge.network

import com.raywenderlich.home_challenge.data.Domus
import com.raywenderlich.home_challenge.data.DomusItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("news")
    suspend fun getRequest(): List<DomusItem>

}