package com.example.sultanposts.domain.enitity.service

import java.io.Serializable

data class ServiceX(
    val id: Int,
    val title: String,
    val subservice: List<Subservice>,
) : Serializable