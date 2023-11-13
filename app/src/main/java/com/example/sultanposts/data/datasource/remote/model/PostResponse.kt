package com.example.sultanposts.data.datasource.remote.model

import android.app.Person
import com.example.sultanposts.domain.enitity.Post
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)