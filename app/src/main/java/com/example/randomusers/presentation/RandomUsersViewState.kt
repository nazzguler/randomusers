package com.example.randomusers.presentation

import com.example.network.api.responses.User

data class RandomUsersViewState(
    val inProgress: Boolean = false,
    val users: List<User> = emptyList(),
    val page: Int? = null
)