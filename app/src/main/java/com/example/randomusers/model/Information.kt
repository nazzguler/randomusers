package com.example.randomusers.model

import com.google.gson.annotations.Expose

data class Information(
    @Expose
    val results: Int?,
    @Expose
    val page: Int?,
    @Expose
    val version: String?
)
