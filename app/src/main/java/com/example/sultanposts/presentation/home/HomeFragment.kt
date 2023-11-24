package com.example.sultanposts.presentation.home

import androidx.navigation.fragment.findNavController
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(){


    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)


    override fun initViews() {
        super.initViews()
    }

    override fun initListeners() {
        super.initListeners()
        val action = HomeFragmentDirections.actionHomeFragmentToChooseBranchFragment()
        binding.btnApply.setOnClickListener {
            findNavController().navigate(action)
        }

    }

    override fun observeData() {
        super.observeData()
    }

    private fun navigateHome(){
        findNavController().popBackStack()
    }

}