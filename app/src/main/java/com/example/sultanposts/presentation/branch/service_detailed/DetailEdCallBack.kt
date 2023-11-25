package com.example.sultanposts.presentation.branch.service_detailed

import androidx.recyclerview.widget.DiffUtil
import com.example.sultanposts.domain.enitity.service.ServiceX
import com.example.sultanposts.domain.enitity.service.Subservice

object DetailEdCallBack : DiffUtil.ItemCallback<Subservice>(){
    override fun areItemsTheSame(oldItem: Subservice, newItem: Subservice): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Subservice, newItem: Subservice): Boolean {
        return oldItem.id == newItem.id
    }

}