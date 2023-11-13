package com.example.sultanposts.presentation.users

import androidx.fragment.app.viewModels
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
    }

    override fun observeData() {
        super.observeData()
        userViewModel.users.observe(viewLifecycleOwner){
            userAdapter.submitList(it)
        }
    }

}