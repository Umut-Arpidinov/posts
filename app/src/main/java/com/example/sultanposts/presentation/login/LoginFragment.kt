package com.example.sultanposts.presentation.login

import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.data.local.Preference
import com.example.sultanposts.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var preference: Preference


    override fun initViews() {
        super.initViews()
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    override fun initListeners() {
        super.initListeners()
        binding.apply {
            btnLogin.setOnClickListener {
                if (etLogin.text.isNotEmpty() && etPassword.text.isNotEmpty()) {
                    val login = etLogin.text.toString().trim()
                    val password = etPassword.text.toString().trim()
                    login(login, password)
                }
            }
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.response.observe(viewLifecycleOwner) {
            onLoginResponseReceived(it)
            binding.apply {
                progressBar.isVisible = false
                constrainLayout.isVisible = true
            }
        }

        viewModel.viewModelError.observe(viewLifecycleOwner) {

        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.apply {
                progressBar.isVisible = true
                constrainLayout.isVisible = false
            }
        }
    }

    private fun onLoginResponseReceived(loginResponse: LoginResponse) {
        Log.d("madimadi", "id in login fragment: ${loginResponse.status}")
        if (loginResponse.status == getString(R.string.success)) {
            preference.id = loginResponse.id.toString()
            Log.d("madimadi", "id in login fragment: ${preference.id}")
            findNavController().navigate(R.id.homeFragment)
        } else {
            binding.tvError.text = getString(R.string.error_text_login)
        }
    }

    private fun login(name: String, password: String) {
        viewModel.login(LoginRequest(name, password))
    }


}