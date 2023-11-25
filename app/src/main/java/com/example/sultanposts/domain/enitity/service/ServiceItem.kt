package com.example.sultanposts.domain.enitity.service

data class ServiceItem(
    val address: String,
    val id: Int,
    val serviceX: List<ServiceX>,
    val status: Boolean,
    val time_from: String,
    val time_to: String
)