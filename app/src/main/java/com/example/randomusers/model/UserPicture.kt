package com.example.randomusers.model

import com.google.gson.annotations.Expose

data class UserPicture(
    @Expose
    val large: String?,
    @Expose
    val medium: String?,
    @Expose
    val thumbnail: String?
)
