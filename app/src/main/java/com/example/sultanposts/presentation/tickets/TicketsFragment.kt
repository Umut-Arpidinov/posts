package com.example.sultanposts.presentation.tickets

import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentTicketsBinding

class TicketsFragment : BaseFragment<FragmentTicketsBinding>() {
    override fun getViewBinding(): FragmentTicketsBinding =
        FragmentTicketsBinding.inflate(layoutInflater)

}