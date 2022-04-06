package com.example.randomusers.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomusers.R
import com.example.randomusers.model.User
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class RandomUsersAdapter(private val users: List<User>) : RecyclerView.Adapter<RandomUsersAdapter.RandomUsersViewHolder>() {

    class RandomUsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userPicture: ImageView? = itemView.findViewById(R.id.userPicture)
        val userFullName: TextView? = itemView.findViewById(R.id.userFullName)
        val userEmail: TextView? = itemView.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val userItem = layoutInflater.inflate(R.layout.user_item, parent,false)
        return RandomUsersViewHolder(userItem)
    }

    override fun onBindViewHolder(holder: RandomUsersViewHolder, position: Int) {
        val randomUser = users[position]
        val firstName = randomUser.name?.first ?: ""
        val lastName = randomUser.name?.last ?: ""
        val email = randomUser.email
        val fullName = StringBuilder().append(firstName).append(" ").append(lastName).toString()
        val userPicture = randomUser.picture

        holder.userFullName?.text = fullName
        holder.userEmail?.text = email
        userPicture?.large?.let { picture->
            Picasso.get().load(picture).into(holder.userPicture)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}