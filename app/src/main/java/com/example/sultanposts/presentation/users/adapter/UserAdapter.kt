package com.example.sultanposts.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.sultanposts.R
import com.example.sultanposts.databinding.ItemUserBinding
import com.example.sultanposts.domain.enitity.User

class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallBack) {

    inner class UserViewHolder(val binding: ItemUserBinding) : ViewHolder(binding.root) {
        fun bind(user: User){
            binding.tvName.text = itemView.resources.getString(R.string.label_username,user.name)
            binding.tvEmail.text = itemView.resources.getString(R.string.label_email,user.email)
            binding.tvCity.text = itemView.resources.getString(R.string.label_city,user.address.city)
            binding.tvCompanyName.text = itemView.resources.getString(R.string.label_company,user.company.name)
            binding.tvZip.text = itemView.resources.getString(R.string.label_zip,user.address.zipcode)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = currentList[position]
        if(currentUser != null){
            holder.bind(currentUser)
        }
        holder.binding
    }
}