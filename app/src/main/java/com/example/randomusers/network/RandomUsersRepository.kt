package com.example.randomusers.network

import com.example.randomusers.model.RandomUsersResponse
import io.reactivex.Single

class RandomUsersRepository(private val randomUsersApi: RandomUsersApi) {

    fun getRandomUsersByResults(page: Int): Single<RandomUsersResponse> {
        return randomUsersApi.getRandomUsers(page)
    }
}