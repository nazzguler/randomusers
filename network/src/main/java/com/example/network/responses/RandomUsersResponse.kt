package com.example.network.responses

import com.example.network.api.responses.User
import kotlinx.serialization.Serializable

@Serializable
data class RandomUsersResponse(
    val results: List<User>?,
    val info: Information
)
