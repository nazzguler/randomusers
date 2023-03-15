package com.example.randomusers.remote

import com.example.network.responses.RandomUsersResponse
import com.example.network.services.RandomUsersService
import com.example.randomusers.repository.RandomUsersRepository

class RandomUsersRepositoryImpl(private val randomUsersService: RandomUsersService) :
    RandomUsersRepository {

    override suspend fun getRandomUsersByResults(quantity: Int): RandomUsersResponse {
        return randomUsersService.getRandomUsers(quantity)
    }
}