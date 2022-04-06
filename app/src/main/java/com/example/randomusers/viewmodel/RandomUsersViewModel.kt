package com.example.randomusers.viewmodel

import androidx.lifecycle.ViewModel
import com.example.randomusers.model.RandomUsersResponse
import com.example.randomusers.network.RandomUsersRepository
import com.example.randomusers.view.RandomUsersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RandomUsersViewModel(
    val randomUsersView: RandomUsersView,
    private val randomUsersRepository: RandomUsersRepository
) : ViewModel() {

    fun getRandomUsers(results: Int) {
        randomUsersView.onLoading()
        randomUsersRepository.getRandomUsersByResults(results)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getRandomUsersSingleObserver())
    }

    private fun getRandomUsersSingleObserver(): DisposableSingleObserver<RandomUsersResponse> {
        return object : DisposableSingleObserver<RandomUsersResponse>() {

            override fun onSuccess(response: RandomUsersResponse) {
                randomUsersView.onSuccess(response)
            }

            override fun onError(error: Throwable) {
                randomUsersView.onFailure(error.toString())
            }
        }
    }
}