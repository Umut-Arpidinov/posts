package com.example.sultanposts.data.repository

import com.example.sultanposts.data.datasource.remote.model.BookRequest
import com.example.sultanposts.data.datasource.remote.model.BookResponse
import com.example.sultanposts.data.datasource.remote.model.HistoryResponse
import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.data.datasource.remote.model.ProfileResponse
import com.example.sultanposts.domain.enitity.Post
import com.example.sultanposts.domain.enitity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface UserRepository {

    fun getUsers(): Single<List<User>>

    fun getPosts(): Single<List<Post>>

    fun getPostById(postId: Int): Single<Post>

    fun getPostsByUserId(userId: Int): Single<List<Post>>

    fun login(loginRequest: LoginRequest): Single<LoginResponse>

    fun getProfileData(id: String): Single<ProfileResponse>

    fun book(bookRequest: BookRequest): Single<BookResponse>

    fun getHistory(id : String): Single<List<HistoryResponse>>

}