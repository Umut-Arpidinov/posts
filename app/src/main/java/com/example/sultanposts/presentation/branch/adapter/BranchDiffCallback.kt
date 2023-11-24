package com.example.sultanposts.presentation.branch.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.sultanposts.domain.enitity.Branch

object BranchDiffCallback : DiffUtil.ItemCallback<Branch>() {
    override fun areItemsTheSame(oldItem: Branch, newItem: Branch): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Branch, newItem: Branch): Boolean {
        return oldItem.id == newItem.id
    }

}