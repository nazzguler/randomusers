package com.example.randomusers.di

import com.example.randomusers.view.UsersListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RandomUsersListActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeUsersListActivityInjector() : UsersListActivity
}