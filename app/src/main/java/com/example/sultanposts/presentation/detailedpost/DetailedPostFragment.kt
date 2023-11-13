package com.example.sultanposts.presentation.detailedpost

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.FragmentDetailedPostBinding
import com.example.sultanposts.domain.enitity.Post
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailedPostFragment : BaseFragment<FragmentDetailedPostBinding>() {

    private val detailedPostViewModel by viewModels<DetailedPostViewModel>()
    private val args by navArgs<DetailedPostFragmentArgs>()
    override fun getViewBinding(): FragmentDetailedPostBinding =
        FragmentDetailedPostBinding.inflate(layoutInflater)


    override fun initViews() {
        super.initViews()
        println(args.postId)
        detailedPostViewModel.getPostById(args.postId)
    }

    override fun initListeners() {
        super.initListeners()
    }

    override fun observeData() =with(binding){
        super.observeData()
        detailedPostViewModel.post.observe(viewLifecycleOwner){
            onPostReceived(it)
        }
        detailedPostViewModel.isLoading.observe(viewLifecycleOwner){
            progressBar.isVisible = it
            tvDescription.isVisible = !it
            tvTitle.isVisible = !it

        }
    }

    private fun onPostReceived(post: Post)=with(binding){
        tvTitle.text = post.title
        tvDescription.text = post.body
    }
}