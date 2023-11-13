package com.example.sultanposts.presentation.detailedpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.domain.enitity.Post
import com.example.sultanposts.domain.usecase.GetUsersPostsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailedPostViewModel @Inject constructor(
    private val getUsersPostsByIdUseCase: GetUsersPostsByIdUseCase
) : BaseViewModel() {

    private val _post: MutableLiveData<Post> = MutableLiveData()
    val post: LiveData<Post> = _post

    fun getPostById(postId: Int) {
        makeRequest(
            getUsersPostsByIdUseCase(postId),
            onSuccess = { _post.value = it },
            onError = { it.printStackTrace() }
        )
    }
}