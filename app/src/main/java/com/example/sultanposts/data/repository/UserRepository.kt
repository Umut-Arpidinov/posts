package com.example.sultanposts.data.repository

import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.domain.enitity.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {

    fun getUsers(): Single<List<User>>

    fun getPosts(): Single<List<PostResponse>>

    fun getPostsByUserId(userId: Int): Single<List<PostResponse>>

}