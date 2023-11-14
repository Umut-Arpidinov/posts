package com.example.sultanposts.presentation.users

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentUsersBinding
import com.example.sultanposts.presentation.users.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    private val userViewModel by viewModels<UserViewModel>()

    private val userAdapter = UserAdapter()

    override fun getViewBinding(): FragmentUsersBinding = FragmentUsersBinding.inflate(layoutInflater)

    override fun initViews() {
        super.initViews()
        binding.rvUsers.adapter = userAdapter
        userViewModel.getUsers()
    }

    override fun initListeners() {
        super.initListeners()
        userAdapter.onUserClickListener { username, userId ->
            val action = UsersFragmentDirections.actionUsersFragmentToPostsFragment(username,userId)
            findNavController().navigate(action)
        }
    }

    override fun observeData()=with(binding){
        super.observeData()
        userViewModel.users.observe(viewLifecycleOwner){
            userAdapter.submitList(it)
        }
        userViewModel.isLoading.observe(viewLifecycleOwner){
            if(it) showShimmer()
            else stopShimmer()
        }
        userViewModel.viewModelError.observe(viewLifecycleOwner){
            it.printStackTrace()
        }


    }

    private fun showShimmer(){
        binding.shimmerLayout.startShimmer()
    }
    private fun stopShimmer(){
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
    }

}