package com.example.sultanposts.data.datasource.mappers

import com.example.sultanposts.data.datasource.remote.model.PostResponse
import com.example.sultanposts.domain.enitity.Post


fun PostResponse.toDomain() = Post(
    body, id, title, userId
)

