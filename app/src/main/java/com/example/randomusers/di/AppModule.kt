package com.example.randomusers.di

import com.example.network.api.RandomUsersApi
import com.example.randomusers.presentation.RandomUsersViewModel
import com.example.randomusers.remote.RandomUsersRepositoryImpl
import com.example.randomusers.repository.RandomUsersRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<RandomUsersApi> { RandomUsersApi.build() }
    single<RandomUsersRepository> {
        RandomUsersRepositoryImpl(get<RandomUsersApi>().users)
    }
    viewModel {
        RandomUsersViewModel(get())
    }
}