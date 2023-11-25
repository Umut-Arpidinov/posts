package com.example.sultanposts.domain.enitity.service

import com.google.gson.annotations.SerializedName

data class Subservice(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)