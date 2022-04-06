package com.example.randomusers.model

import com.google.gson.annotations.Expose

data class User(
    @Expose
    val gender: String?,
    @Expose
    val phone: String?,
    @Expose
    val picture: UserPicture?,
    @Expose
    val email: String?,
    @Expose
    val name: UserName?
)
