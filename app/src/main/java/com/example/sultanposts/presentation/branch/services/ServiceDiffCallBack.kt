package com.example.sultanposts.presentation.branch.services

import androidx.recyclerview.widget.DiffUtil
import com.example.sultanposts.domain.enitity.service.ServiceX

object ServiceDiffCallBack : DiffUtil.ItemCallback<ServiceX>(){
    override fun areItemsTheSame(oldItem: ServiceX, newItem: ServiceX): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ServiceX, newItem: ServiceX): Boolean {
       return oldItem.id == newItem.id
    }

}