package com.example.sultanposts.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username")
    var userName : String?=null,
    var password : String?=null
)
