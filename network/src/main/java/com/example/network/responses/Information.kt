package com.example.network.responses

import kotlinx.serialization.Serializable


@Serializable
data class Information(
    val results: Int?,
    val page: Int?,
    val version: String?
)
