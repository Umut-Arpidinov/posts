package com.example.sultanposts.presentation.branch.services

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.sultanposts.R

class ServiceSpinnerAdapter<M>(
    context: Context,
    list: List<M>
) : ArrayAdapter<M>(context, R.layout.item_service, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return when (position) {
            0 -> LayoutInflater.from(context).inflate(R.layout.item_service, parent, false).apply {
                (this as TextView).text = getItem(position)?.toString()
            }
            else -> super.getView(position, convertView, parent)
        }
    }

    override fun addAll(collection: MutableCollection<out M>) {
        super.addAll(collection)

    }
}