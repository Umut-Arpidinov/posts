package com.example.sultanposts.presentation.users.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.sultanposts.domain.enitity.User

object UserDiffCallBack : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}