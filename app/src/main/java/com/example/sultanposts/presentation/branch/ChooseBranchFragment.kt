package com.example.sultanposts.presentation.branch

import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentChooseBranchBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ChooseBranchFragment : BaseFragment<FragmentChooseBranchBinding>(){

    override fun getViewBinding(): FragmentChooseBranchBinding = FragmentChooseBranchBinding.inflate(layoutInflater)


}