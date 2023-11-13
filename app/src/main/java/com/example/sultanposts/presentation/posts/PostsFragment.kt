package com.example.sultanposts.presentation.posts

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentPostsBinding
import com.example.sultanposts.presentation.posts.adapter.PostListAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostsFragment : BaseFragment<FragmentPostsBinding>() {

    private val args by navArgs<PostsFragmentArgs>()
    private val postViewModel by viewModels<PostsViewModel>()
    private val postAdapter = PostListAdapter()
    override fun getViewBinding(): FragmentPostsBinding =
        FragmentPostsBinding.inflate(layoutInflater)

    override fun initViews()=with(binding){
        super.initViews()
        tvUser.text = args.user
        rvUsersPosts.adapter = postAdapter
        postViewModel.getPostsOfUser(args.userId)

    }

    override fun initListeners() {
        super.initListeners()
        postAdapter.setOnPostClickListener { postId ->
            val action = PostsFragmentDirections.actionPostsFragmentToDetailedPostFragment(postId)
            findNavController().navigate(action)
        }
    }

    override fun observeData() {
        super.observeData()
        postViewModel.posts.observe(viewLifecycleOwner){
            postAdapter.submitList(it)
        }
        postViewModel.isLoading.observe(viewLifecycleOwner){
            if(it) showShimmer()
            else stopShimmer()
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