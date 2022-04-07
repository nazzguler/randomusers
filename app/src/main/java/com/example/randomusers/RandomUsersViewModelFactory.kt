package com.example.randomusers

import com.example.randomusers.network.RandomUsersRepository
import com.example.randomusers.viewmodel.RandomUsersViewModel

class RandomUsersViewModelFactory(private val randomUsersRepository: RandomUsersRepository) :
    Factory<RandomUsersViewModel> {

    override fun create(): RandomUsersViewModel {
        return RandomUsersViewModel(randomUsersRepository)
    }

}