package com.example.sultanposts.presentation.tickets

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sultanposts.data.datasource.remote.model.HistoryResponse
import com.example.sultanposts.databinding.ItemTicketBinding

class TicketsAdapter :
    RecyclerView.Adapter<TicketsAdapter.TicketViewHolder>() {

    private var list = arrayListOf<HistoryResponse>()

    fun updateList(it: List<HistoryResponse>) {
        list = it as ArrayList<HistoryResponse>
        notifyDataSetChanged()
    }

    inner class TicketViewHolder(private val binding: ItemTicketBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(history: HistoryResponse) {
            binding.tvNumber.text = history.id
            binding.tvDate.text = history.day
            binding.tvTime.text = history.time
            binding.tvAddress.text = history.address?.get(0)?.address
            binding.tvService.text = history.service
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        return TicketViewHolder(
            ItemTicketBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val instructor = list[position]
        holder.bind(instructor)
    }

}