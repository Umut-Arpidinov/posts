package com.example.sultanposts.data.datasource.remote

import com.example.sultanposts.data.datasource.remote.model.BookRequest
import com.example.sultanposts.data.datasource.remote.model.BookResponse
import com.example.sultanposts.data.datasource.remote.model.HistoryResponse
import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.data.datasource.remote.model.ProfileResponse
import com.example.sultanposts.data.datasource.remote.model.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface UserRemoteDataSource {

    fun getUsers(): Single<List<UserResponse>>

    fun getPosts(): Single<List<PostResponse>>

    fun getPostById(postId: Int): Single<PostResponse>

    fun getPostsByUserId(userId: Int): Single<List<PostResponse>>

    fun fetchData(): Call<PostResponse>

    fun login(loginRequest: LoginRequest): Single<LoginResponse>

    fun getProfileData(id : String): Single<ProfileResponse>

    fun book(bookRequest: BookRequest): Single<BookResponse>

    fun getHistory(id : String): Single<List<HistoryResponse>>
}