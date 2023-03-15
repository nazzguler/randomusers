package com.example.network.api.responses

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val gender: String?,
    val phone: String?,
    val picture: UserPicture?,
    val email: String?,
    val name: UserName?
) {
    fun getFullName() = run {
        val first = this.name?.first ?: "-"
        val last = this.name?.last ?: "-"
        "$first $last"
    }
}
@Serializable
data class UserPicture(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)
@Serializable
data class UserName(
    val title: String?,
    val first: String?,
    val last: String?
)
