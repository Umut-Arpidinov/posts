package com.example.sultanposts.presentation.branch.services


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanposts.databinding.SubServiceItemBinding
import com.example.sultanposts.domain.enitity.service.Subservice
import com.example.sultanposts.presentation.branch.service_detailed.DetailEdCallBack

class ServiceDetailedAdapter(val onClick : (Int) -> Unit) :
    ListAdapter<Subservice, ServiceDetailedAdapter.ServiceViewHolder>(DetailEdCallBack) {

    private var onServiceListener: ((subservice: Subservice) -> Unit)? = null

    fun onServiceListener(listener: (subservice: Subservice) -> Unit) {
        onServiceListener = listener
    }

    inner class ServiceViewHolder(val binding: SubServiceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subservice: Subservice) {
            itemView.setOnClickListener{
                onClick(subservice.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val binding =
            SubServiceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.binding.apply {
            holder.bind(currentItem)
            onServiceListener?.invoke(currentItem)
        }
    }



}