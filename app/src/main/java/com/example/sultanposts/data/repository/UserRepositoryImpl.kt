package com.example.sultanposts.data.repository

import com.example.sultanposts.data.datasource.mappers.toDomain
import com.example.sultanposts.data.datasource.remote.UserRemoteDataSource
import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.domain.enitity.User
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override fun getUsers(): Single<List<User>> {
        return userRemoteDataSource.getUsers().map { it.map { it.toDomain() } }

    }

    override fun getPosts(): Single<List<PostResponse>> {
        return userRemoteDataSource.getPosts()
    }

    override fun getPostsByUserId(userId: Int): Single<List<PostResponse>> {
        return userRemoteDataSource.getPostsByUserId(userId)
    }
}