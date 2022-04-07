package com.example.randomusers

import android.app.Application
import com.example.randomusers.di.AppModule
import com.example.randomusers.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class RandomUsersApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}