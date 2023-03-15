package com.example.randomusers.repository

import com.example.network.responses.RandomUsersResponse

interface RandomUsersRepository {
    suspend fun getRandomUsersByResults(quantity: Int): RandomUsersResponse
}