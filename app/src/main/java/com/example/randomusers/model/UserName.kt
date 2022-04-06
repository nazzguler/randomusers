package com.example.randomusers.model

import com.google.gson.annotations.Expose

data class UserName(
    @Expose
    val title: String?,
    @Expose
    val first: String?,
    @Expose
    val last: String?
)
