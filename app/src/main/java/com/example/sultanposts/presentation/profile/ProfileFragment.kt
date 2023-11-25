package com.example.sultanposts.presentation.profile

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.data.local.Preference
import com.example.sultanposts.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var preference: Preference

    override fun getViewBinding(): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater)

    override fun observeData() {
        super.observeData()
        viewModel.getProfileData(preference.id!!)
        viewModel.response.observe(viewLifecycleOwner) { response ->
            with(binding) {
                progressBar.isVisible = false
                mainContainer.isVisible = true

                tvName.text = response.firstName
                tvLastname.text = response.lastName
                tvNumber.text = response.phoneNumber
                if (response.status == true) {
                    tvStatus.isVisible = true
                    imgVip.isVisible = true
                } else {
                    tvStatus.isVisible = false
                    imgVip.isVisible = false
                }
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.apply {
                progressBar.isVisible = true
                mainContainer.isVisible = false
            }
        }
    }
}