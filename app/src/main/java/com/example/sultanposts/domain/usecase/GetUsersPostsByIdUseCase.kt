package com.example.sultanposts.domain.usecase

import com.example.sultanposts.data.repository.UserRepository
import javax.inject.Inject

class GetUsersPostsByIdUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

}