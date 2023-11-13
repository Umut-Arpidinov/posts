package com.example.sultanposts.domain.usecase

import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.domain.enitity.Post
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUsersPostsUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(userId: Int): Single<List<Post>> {
        return repository.getPostsByUserId(userId)
    }
}