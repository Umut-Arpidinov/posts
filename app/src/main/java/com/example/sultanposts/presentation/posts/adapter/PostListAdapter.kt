package com.example.sultanposts.presentation.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sultanposts.databinding.ItemPostBinding
import com.example.sultanposts.domain.enitity.Post

class PostListAdapter : ListAdapter<Post, PostListAdapter.PostViewHolder>(PostDiffUtil) {

    private var postOnClickCallBack: ((postId: Int) -> Unit)? = null

    fun setOnPostClickListener(callback: ((postId: Int) -> Unit)?){
        postOnClickCallBack = callback
    }


    inner class PostViewHolder(val binding: ItemPostBinding) : ViewHolder(binding.root) {
        fun bind(post: Post, position: Int) = with(binding) {
            val order = position + 1
            tvTitle.text = post.title
            tvPostNum.text = order.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = currentList[position]
        if (currentPost != null) {
            holder.bind(currentPost, position)
        }
        holder.binding.linearItem.setOnClickListener {
            postOnClickCallBack?.invoke(currentPost.id)
        }
    }
}