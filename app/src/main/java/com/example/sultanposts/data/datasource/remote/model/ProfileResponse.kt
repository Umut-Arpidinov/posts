package com.example.sultanposts.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("first_name")
    var firstName : String?=null,
    @SerializedName("last_name")
    var lastName : String?=null,
    @SerializedName("phone_number")
    var phoneNumber : String?=null,
    var status : Boolean?=null
)
