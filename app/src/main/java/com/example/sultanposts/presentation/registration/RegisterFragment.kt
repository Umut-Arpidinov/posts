package com.example.sultanposts.presentation.registration

import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentLoginBinding
import com.example.sultanposts.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    override fun getViewBinding(): FragmentRegisterBinding =
        FragmentRegisterBinding.inflate(layoutInflater)

}