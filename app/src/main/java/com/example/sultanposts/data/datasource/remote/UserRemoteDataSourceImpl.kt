package com.example.sultanposts.data.datasource.remote

import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.data.datasource.remote.model.UserResponse
import com.example.sultanposts.data.datasource.remote.service.UserApiService
import com.example.sultanposts.domain.enitity.Branch
import com.example.sultanposts.domain.enitity.service.ServiceX
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject
import kotlin.math.log

class UserRemoteDataSourceImpl @Inject constructor(
    private val userApiService: UserApiService
): UserRemoteDataSource {

    override fun getUsers(): Single<List<UserResponse>> {
        return userApiService.getUsers()
    }

    override fun getPosts(): Single<List<PostResponse>> {
        return userApiService.getPosts()
    }

    override fun getPostById(postId: Int): Single<PostResponse> {
        return userApiService.getPostById(postId)
    }

    override fun getPostsByUserId(userId: Int): Single<List<PostResponse>> {
        return userApiService.getUsersPostById(userId)
    }

    override fun fetchData(): Call<PostResponse> {
        return userApiService.fetchData()
    }

    override fun login(loginRequest: LoginRequest): Single<LoginResponse> {
        return userApiService.login(loginRequest)
    }

    override fun getServices(): Single<List<ServiceX>> {
        return userApiService.getService()
    }

    override fun getBranches(): Single<List<Branch>> {
        return userApiService.getBranches()
    }

}