package com.example.randomusers.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.randomusers.presentation.RandomUsersScreen
import com.example.randomusers.presentation.RandomUsersViewModel
import org.koin.androidx.compose.getViewModel

class UsersListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm = getViewModel<RandomUsersViewModel>()
            RandomUsersScreen(vm)
        }
    }
}