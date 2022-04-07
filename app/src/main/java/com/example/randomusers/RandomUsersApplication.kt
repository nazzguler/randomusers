package com.example.randomusers

import android.app.Application
import com.example.randomusers.di.AppContainer

class RandomUsersApplication : Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}