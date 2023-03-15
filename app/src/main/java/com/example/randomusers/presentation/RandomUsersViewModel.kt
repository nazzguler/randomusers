package com.example.randomusers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusers.repository.RandomUsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RandomUsersViewModel(
    private val randomUsersRepository: RandomUsersRepository
) : ViewModel() {

    val state: MutableStateFlow<RandomUsersViewState> = MutableStateFlow(RandomUsersViewState())

    init {
        fetchRandomUsers()
    }

    fun fetchRandomUsers() {
        state.value = state.value.copy(inProgress = true)
        viewModelScope.launch(Dispatchers.IO) {
            val response =
                randomUsersRepository.getRandomUsersByResults(30) // hardcoded page for now
            if (response.results != null) {
                state.value = state.value.copy(
                    users = response.results!!,
                    page = response.info.page
                )
            }
            state.value = state.value.copy(inProgress = false)
        }
    }
}