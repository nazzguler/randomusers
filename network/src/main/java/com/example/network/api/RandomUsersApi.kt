package com.example.network.api

import com.example.network.services.RandomUsersService
import com.example.network.services.RandomUsersServiceImpl
import io.ktor.client.HttpClient
import io.ktor.client.features.json.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json
import io.ktor.client.features.json.JsonFeature

const val randomUsersApi: String = "https://randomuser.me"


class RandomUsersApi(
    private val client: HttpClient
) {
    companion object {
        fun build(): RandomUsersApi {
            return RandomUsersApi(
                HttpClient {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer(
                            Json {
                                ignoreUnknownKeys = true
                                developmentMode = true
                            }
                        )
                    }
                }
            )
        }
    }
    val users: RandomUsersService by lazy { RandomUsersServiceImpl(client, randomUsersApi) }
}