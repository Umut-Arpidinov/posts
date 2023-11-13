package com.example.sultanposts.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.domain.enitity.Post
import com.example.sultanposts.domain.usecase.GetUsersPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getUsersPostsUseCase: GetUsersPostsUseCase
) : BaseViewModel() {

    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>> = _posts

    fun getPostsOfUser(userId: Int){
        makeRequest(
            getUsersPostsUseCase(userId),
            onSuccess = {_posts.value = it},
            onError = {it.printStackTrace()}
        )
    }
}