package com.example.sultanposts.domain.enitity

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)


data class Geo(
    val lat: String,
    val lng: String
)

data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
)

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)