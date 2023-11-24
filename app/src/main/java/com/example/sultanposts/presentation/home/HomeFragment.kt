package com.example.sultanposts.presentation.home

import androidx.navigation.fragment.findNavController
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.data.local.Preference
import com.example.sultanposts.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(){

    @Inject
    lateinit var preference: Preference

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkId()

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

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun checkId(){
        if(preference.id == null){
            findNavController().navigate(R.id.loginFragment)
        }
    }
}