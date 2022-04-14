package com.example.randomusers.view

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomusers.R
import com.example.randomusers.model.RandomUsersResponse
import com.example.randomusers.viewmodel.RandomUsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersListActivity : AppCompatActivity(), RandomUsersView {

    private val viewModel: RandomUsersViewModel by viewModels()
    private lateinit var progressBar: ProgressBar
    private val tag = UsersListActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        progressBar = findViewById(R.id.progressBar)
        viewModel.randomUsersView = this
        viewModel.getRandomUsers(30)
    }

    override fun onLoading() {
        progressBar.visibility = VISIBLE
    }

    override fun onFailure(message: String) {
        progressBar.visibility = GONE
        Log.e(tag, message)
    }

    override fun onSuccess(randomUsersResponse: RandomUsersResponse) {
        progressBar.visibility = GONE
        randomUsersResponse.results?.let { userList ->
            val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
            recyclerView.adapter = RandomUsersAdapter(userList)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}