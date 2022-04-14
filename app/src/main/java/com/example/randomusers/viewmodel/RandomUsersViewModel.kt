package com.example.randomusers.viewmodel

import androidx.lifecycle.ViewModel
import com.example.randomusers.network.RandomUsersRepository
import com.example.randomusers.utils.Coroutines
import com.example.randomusers.view.RandomUsersView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RandomUsersViewModel @Inject constructor(
    private val randomUsersRepository: RandomUsersRepository
) : ViewModel() {
    var randomUsersView: RandomUsersView? = null

    fun getRandomUsers(results: Int) {
        randomUsersView?.onLoading()
        Coroutines.main {
            val response = randomUsersRepository.getRandomUsersByResults(results)
            if (response.isSuccessful) {
                response.body()?.let { r ->
                    randomUsersView?.onSuccess(r)
                }
            } else {
                randomUsersView?.onFailure(response.code().toString())
            }
        }
    }
}