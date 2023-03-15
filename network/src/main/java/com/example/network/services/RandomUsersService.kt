package com.example.network.services

import com.example.network.responses.RandomUsersResponse

interface RandomUsersService {
    suspend fun getRandomUsers(page: Int): RandomUsersResponse
}