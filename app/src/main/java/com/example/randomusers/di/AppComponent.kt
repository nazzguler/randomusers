package com.example.randomusers.di

import com.example.randomusers.RandomUsersApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        RandomUsersListActivityModule::class
    ]
)
interface AppComponent {
    fun inject(application: RandomUsersApplication)
}