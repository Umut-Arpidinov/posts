package com.example.sultanposts.data.datasource.remote

import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.data.datasource.remote.model.UserResponse
import com.example.sultanposts.domain.enitity.Branch
import com.example.sultanposts.domain.enitity.service.ServiceX
import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface UserRemoteDataSource {

    fun getUsers(): Single<List<UserResponse>>

    fun getPosts(): Single<List<PostResponse>>

    fun getPostById(postId: Int): Single<PostResponse>

    fun getPostsByUserId(userId: Int): Single<List<PostResponse>>

    fun fetchData(): Call<PostResponse>

    fun login(loginRequest: LoginRequest): Single<LoginResponse>

    fun getServices(): Single<List<ServiceX>>

    fun getBranches(): Single<List<Branch>>
}