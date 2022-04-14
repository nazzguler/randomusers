package com.example.randomusers.di

import android.content.Context
import com.example.randomusers.network.RandomUsersApi
import com.example.randomusers.network.RetrofitManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Context is not being used, is just a demo on how we should get it when needed**/
    @Provides
    fun provideRandomUsersApi(@ApplicationContext context: Context): RandomUsersApi {
        return RetrofitManager.getRetrofitClient().create(RandomUsersApi::class.java)
    }
}