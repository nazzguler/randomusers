package com.example.randomusers.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitManager @Inject constructor() {

    companion object {
        private const val randomUsersApi: String = "https://randomuser.me"

        fun getRetrofitClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(randomUsersApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}