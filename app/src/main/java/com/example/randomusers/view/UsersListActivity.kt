package com.example.randomusers.view

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomusers.R
import com.example.randomusers.RandomUsersApplication
import com.example.randomusers.di.AppContainer
import com.example.randomusers.di.RandomUsersContainer
import com.example.randomusers.model.RandomUsersResponse
import com.example.randomusers.viewmodel.RandomUsersViewModel

class UsersListActivity : AppCompatActivity(), RandomUsersView {

    private var viewModel: RandomUsersViewModel? = null
    private lateinit var progressBar: ProgressBar
    private val tag = UsersListActivity::class.java.simpleName
    lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = (application as RandomUsersApplication).appContainer
        appContainer.randomUsersContainer = RandomUsersContainer(appContainer.randomUsersRepository)
        setContentView(R.layout.activity_user_list)
        progressBar = findViewById(R.id.progressBar)

        viewModel = appContainer.randomUsersContainer?.viewModelFactory?.create()
        viewModel?.randomUsersView = this
        viewModel?.getRandomUsers(30)
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

    override fun onDestroy() {
        super.onDestroy()
        appContainer.randomUsersContainer = null
    }
}