package com.example.sultanposts.presentation.posts

import androidx.lifecycle.ViewModel
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.domain.usecase.GetUsersPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getUsersPostsUseCase: GetUsersPostsUseCase
) : BaseViewModel() {
    // TODO: Implement the ViewModel
}