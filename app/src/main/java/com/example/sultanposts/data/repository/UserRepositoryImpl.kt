package com.example.sultanposts.data.repository

import com.example.sultanposts.data.datasource.mappers.toDomain
import com.example.sultanposts.data.datasource.remote.UserRemoteDataSource
import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.domain.enitity.Branch
import com.example.sultanposts.domain.enitity.Post
import com.example.sultanposts.domain.enitity.User
import com.example.sultanposts.domain.enitity.service.ServiceX
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override fun getUsers(): Single<List<User>> {
        return userRemoteDataSource.getUsers().map { it.map { it.toDomain() } }

    }

    override fun getPosts(): Single<List<Post>> {
        return userRemoteDataSource.getPosts().map { it.map { it.toDomain() } }
    }

    override fun getPostById(postId: Int): Single<Post> {
        return userRemoteDataSource.getPostById(postId).map { it.toDomain() }
    }

    override fun getPostsByUserId(userId: Int): Single<List<Post>> {
        return userRemoteDataSource.getPostsByUserId(userId).map { it.map { it.toDomain() } }
    }

    override fun login(loginRequest: LoginRequest): Single<LoginResponse> {
        return userRemoteDataSource.login(loginRequest)
    }

    override fun fetchService(): Single<List<ServiceX>> {
        return userRemoteDataSource.getServices()
    }

    override fun fetchBranches(): Single<List<Branch>> {
        return userRemoteDataSource.getBranches()
    }
}