package com.example.randomusers.network

import com.example.randomusers.model.RandomUsersResponse
import retrofit2.Response

class RandomUsersRepository(private val randomUsersApi: RandomUsersApi) {

    suspend fun getRandomUsersByResults(page: Int): Response<RandomUsersResponse> {
        return randomUsersApi.getRandomUsers(page)
    }
}