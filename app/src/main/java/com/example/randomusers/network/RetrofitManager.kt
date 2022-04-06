package com.example.randomusers.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {

    companion object {
        private const val randomUsersApi: String = "https://randomuser.me"

        fun getRetrofitClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(randomUsersApi)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}