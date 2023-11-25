package com.example.sultanposts.domain.enitity

import com.example.sultanposts.domain.enitity.service.ServiceX
import java.io.Serializable


data class Branch(
    val address: String,
    val id: Int,
    val service: List<ServiceX>,
    val status: Boolean,
    val time_from: String,
    val time_to: String,
) : Serializable
