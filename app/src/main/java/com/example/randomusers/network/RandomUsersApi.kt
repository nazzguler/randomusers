package com.example.randomusers.network

import com.example.randomusers.model.RandomUsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUsersApi {

    @GET("/api")
    suspend fun getRandomUsers(
        @Query("results") page: Int
    ): Response<RandomUsersResponse>
}