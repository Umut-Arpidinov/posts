package com.example.sultanposts.domain.usecase

import com.example.sultanposts.data.datasource.mappers.toDomain
import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.domain.enitity.User
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
   operator fun invoke(): Single<List<User>> {
       return repository.getUsers()
   }
}