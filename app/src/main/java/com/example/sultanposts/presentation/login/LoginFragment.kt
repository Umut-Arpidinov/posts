package com.example.sultanposts.presentation.login

import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

}