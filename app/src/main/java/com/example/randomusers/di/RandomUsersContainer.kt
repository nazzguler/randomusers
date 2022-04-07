package com.example.randomusers.di

import com.example.randomusers.RandomUsersViewModelFactory
import com.example.randomusers.network.RandomUsersRepository

class RandomUsersContainer(
    repository: RandomUsersRepository
) {
    val viewModelFactory = RandomUsersViewModelFactory(repository)
}