package com.example.sultanposts.presentation.profile

import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

}