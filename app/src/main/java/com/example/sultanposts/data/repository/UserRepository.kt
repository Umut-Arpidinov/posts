package com.example.sultanposts.data.repository

import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.domain.enitity.Post
import com.example.sultanposts.domain.enitity.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {

    fun getUsers(): Single<List<User>>

    fun getPosts(): Single<List<Post>>

    fun getPostById(postId: Int): Single<Post>

    fun getPostsByUserId(userId: Int): Single<List<Post>>

}