package com.example.sultanposts.presentation.branch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanposts.R
import com.example.sultanposts.R.id.tv_address
import com.example.sultanposts.domain.enitity.Branch

class BranchAdapter : ListAdapter<Branch, BranchAdapter.BranchViewHolder>(BranchDiffCallback) {

    private var onBranchListener: ((id: Long) -> Unit)? = null

    fun setOnBranchClickListener(listener: (id: Long) -> Unit) {
        onBranchListener = listener
    }

    inner class BranchViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val tvAddress: TextView = itemView.findViewById(tv_address)
        fun bind(branch: Branch) {
            tvAddress.text = branch.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchViewHolder {
        val layout = when (viewType) {
            BRANCH_CLOSED -> R.layout.item_branch_closed
            BRANCH_OPENED -> R.layout.item_branch_open
            else -> throw RuntimeException("Unknown View Type")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BranchViewHolder(view)
    }

    override fun onBindViewHolder(holder: BranchViewHolder, position: Int) {
        val currentBranch = currentList[position]
        holder.bind(currentBranch)
        holder.view.setOnClickListener{
            onBranchListener?.invoke(currentBranch.id)
        }

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.status) BRANCH_OPENED
        else BRANCH_CLOSED
    }


    companion object {
        const val BRANCH_CLOSED = 0
        const val BRANCH_OPENED = 1
    }


}