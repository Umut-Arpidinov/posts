package com.example.sultanposts.presentation.branch

import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentChooseBranchBinding
import com.example.sultanposts.domain.enitity.Branch
import com.example.sultanposts.presentation.branch.adapter.BranchAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChooseBranchFragment : BaseFragment<FragmentChooseBranchBinding>() {


    private val branchAdapter = BranchAdapter()


    override fun getViewBinding(): FragmentChooseBranchBinding =
        FragmentChooseBranchBinding.inflate(layoutInflater)


    override fun initViews() {
        hideNavBar()
        super.initViews()

        binding.recyclerViewBranches.adapter  = branchAdapter
    }

    override fun initListeners() {
        super.initListeners()

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun observeData() {
        super.observeData()
        branchAdapter.submitList(generateFakeData())
    }


    private fun generateFakeData(): List<Branch> {
        return listOf(
            Branch(1, resources.getString(R.string.random_address), true),
            Branch(1, resources.getString(R.string.random_address), true),
            Branch(1, resources.getString(R.string.random_address), true),
            Branch(1, resources.getString(R.string.random_address), false),
            Branch(1, resources.getString(R.string.random_address), true),
            Branch(1, resources.getString(R.string.random_address), false),
            Branch(1, resources.getString(R.string.random_address), true),
            Branch(1, resources.getString(R.string.random_address), true),
            Branch(1, resources.getString(R.string.random_address), true),

            )
    }
    private fun hideNavBar(){
        val navBar = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)
        navBar?.visibility = View.GONE
    }

}