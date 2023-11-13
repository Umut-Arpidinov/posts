package com.example.sultanposts.presentation.posts.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.sultanposts.domain.enitity.Post

object PostDiffUtil : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.userId
    }
}