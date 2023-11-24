package com.example.sultanposts.data.datasource.remote.service

import com.example.sultanposts.data.datasource.remote.model.LoginRequest
import com.example.sultanposts.data.datasource.remote.model.LoginResponse
import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.data.datasource.remote.model.UserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiService {

    @GET("users")
    fun getUsers(): Single<List<UserResponse>>

    @GET("posts")
    fun getPosts(): Single<List<PostResponse>>

    @GET("posts")
    fun getUsersPostById(@Query("userId") userId: Int): Single<List<PostResponse>>

    @GET("posts/{postId}")
    fun getPostById(@Path("postId") postId: Int): Single<PostResponse>


    @GET()
    fun fetchData(): Call<PostResponse>

    @POST("user/authorization/")
    fun login(@Body loginRequest: LoginRequest) : Single<LoginResponse>
}