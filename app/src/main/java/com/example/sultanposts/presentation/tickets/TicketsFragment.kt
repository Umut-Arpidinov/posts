package com.example.sultanposts.presentation.tickets

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.data.local.Preference
import com.example.sultanposts.databinding.FragmentTicketsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TicketsFragment : BaseFragment<FragmentTicketsBinding>() {
    override fun getViewBinding(): FragmentTicketsBinding =
        FragmentTicketsBinding.inflate(layoutInflater)

    private val adapter = TicketsAdapter()

    @Inject
    lateinit var preference: Preference

    private val viewModel: TicketsViewModel by viewModels()

    override fun observeData() {
        super.observeData()
        viewModel.getHistory(preference.id!!)
        viewModel.response.observe(viewLifecycleOwner) { response ->
            binding.progressBar.isVisible = false
            binding.mainContainer.isVisible = true
            binding.recyclerView.adapter = adapter
            adapter.updateList(response)
            Log.e("madimadi", "list: $response" )
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.apply {
                progressBar.isVisible = true
                mainContainer.isVisible = false
            }
        }
    }
}