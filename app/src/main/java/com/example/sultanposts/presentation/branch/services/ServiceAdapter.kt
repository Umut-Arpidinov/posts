package com.example.sultanposts.presentation.branch.services


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanposts.databinding.ItemServiceBinding
import com.example.sultanposts.domain.enitity.service.ServiceX

class ServiceAdapter(val array: ArrayAdapter<*>) :
    ListAdapter<ServiceX, ServiceAdapter.ServiceViewHolder>(ServiceDiffCallBack) {

    private var onServiceListener: ((serviceX: ServiceX) -> Unit)? = null

    fun onServiceListener(listener: (serviceX: ServiceX) -> Unit) {
        onServiceListener = listener
    }

    inner class ServiceViewHolder(val binding: ItemServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(serviceX: ServiceX) {
            binding.tvServiceName.text = serviceX.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val binding =
            ItemServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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