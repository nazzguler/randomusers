package com.example.network.services

import com.example.network.responses.RandomUsersResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RandomUsersServiceImpl(
    private val client: HttpClient,
    private val baseUrl: String
) : RandomUsersService {
    override suspend fun getRandomUsers(page: Int): RandomUsersResponse =
        client.get("$baseUrl/api") {
            parameter("results", page)
        }
}