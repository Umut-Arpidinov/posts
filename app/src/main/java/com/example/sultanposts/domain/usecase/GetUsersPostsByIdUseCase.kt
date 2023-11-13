package com.example.sultanposts.domain.usecase

import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.domain.enitity.Post
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUsersPostsByIdUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(postId: Int): Single<Post>{
        return userRepository.getPostById(postId)
    }
}