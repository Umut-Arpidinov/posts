package com.example.sultanposts.data.datasource.remote.model

import com.example.sultanposts.domain.enitity.User
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("address")
    val address: AddressResponse,
    @SerializedName("company")
    val company: CompanyResponse,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
){

}

data class GeoResponse(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)

data class CompanyResponse(
    @SerializedName("bs")
    val bs: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("name")
    val name: String
)

data class AddressResponse(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geo: GeoResponse,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)