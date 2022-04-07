package com.example.randomusers.di

import android.content.Context
import com.example.randomusers.network.RandomUsersApi
import com.example.randomusers.network.RetrofitManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context
) {
    @Singleton
    @Provides
    fun provideRandomUsersApi(): RandomUsersApi {
        return RetrofitManager.getRetrofitClient().create(RandomUsersApi::class.java)
    }
}