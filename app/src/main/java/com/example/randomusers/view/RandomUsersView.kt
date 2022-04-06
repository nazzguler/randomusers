package com.example.randomusers.view

import com.example.randomusers.model.RandomUsersResponse

interface RandomUsersView {
    fun onLoading()
    fun onFailure(message : String)
    fun onSuccess(randomUsersResponse: RandomUsersResponse)
}