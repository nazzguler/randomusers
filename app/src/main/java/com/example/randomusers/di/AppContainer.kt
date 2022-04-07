package com.example.randomusers.di

import android.content.Context
import com.example.randomusers.network.RandomUsersApi
import com.example.randomusers.network.RandomUsersRepository
import com.example.randomusers.network.RetrofitManager

class AppContainer(context: Context) {
    private val randomUsersApi =
        RetrofitManager.getRetrofitClient().create(RandomUsersApi::class.java)
    val randomUsersRepository = RandomUsersRepository(randomUsersApi)
    var randomUsersContainer: RandomUsersContainer? = null
}