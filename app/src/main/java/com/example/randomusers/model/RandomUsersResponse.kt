package com.example.randomusers.model

import com.google.gson.annotations.Expose

data class RandomUsersResponse(
    @Expose
    val results: List<User>?,
    @Expose
    val info: Information
)
