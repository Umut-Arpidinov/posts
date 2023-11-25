package com.example.sultanposts.presentation.branch

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentChooseBranchBinding
import com.example.sultanposts.presentation.branch.adapter.BranchAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChooseBranchFragment : BaseFragment<FragmentChooseBranchBinding>() {


    private val branchAdapter = BranchAdapter()

    private val viewModel by viewModels<ChooseFragmentViewModel>()

    override fun getViewBinding(): FragmentChooseBranchBinding =
        FragmentChooseBranchBinding.inflate(layoutInflater)


    override fun initViews() {
        hideNavBar()
        super.initViews()
        viewModel.getBranches()
        binding.recyclerViewBranches.adapter = branchAdapter
    }

    override fun initListeners() {
        super.initListeners()

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        branchAdapter.setOnBranchClickListener {
            val action =
                ChooseBranchFragmentDirections.actionChooseBranchFragmentToServicesFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.branch.observe(viewLifecycleOwner) {
            branchAdapter.submitList(it)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.recyclerViewBranches.isVisible = !it
            binding.progressBar.isVisible = it
        }
    }


    private fun hideNavBar() {
        val navBar = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)
        navBar?.visibility = View.GONE
    }

}