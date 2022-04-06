package com.example.randomusers.viewmodel

import androidx.lifecycle.ViewModel
import com.example.randomusers.network.RandomUsersRepository
import com.example.randomusers.view.RandomUsersView

class RandomUsersViewModel(
    val randomUsersView: RandomUsersView,
    private val randomUsersRepository: RandomUsersRepository
) : ViewModel() {

    fun getRandomUsers(results: Int) {
        randomUsersRepository.getRandomUsersByResults(results)
    }
}