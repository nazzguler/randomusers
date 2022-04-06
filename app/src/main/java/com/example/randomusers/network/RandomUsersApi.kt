package com.example.randomusers.network

import com.example.randomusers.model.RandomUsersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUsersApi {

    @GET("/api")
    fun getRandomUsers(
        @Query("results") page: Int
    ): Single<RandomUsersResponse>
}