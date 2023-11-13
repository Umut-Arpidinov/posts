package com.example.sultanposts.domain.usecase

import com.example.sultanposts.data.repository.UserRepository
import javax.inject.Inject

class GetUsersPostsUseCase @Inject constructor(
    repository: UserRepository
) {
}