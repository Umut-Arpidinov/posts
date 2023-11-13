package com.example.sultanposts.di

import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.domain.usecase.GetUsersPostsByIdUseCase
import com.example.sultanposts.domain.usecase.GetUsersPostsUseCase
import com.example.sultanposts.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUsersUseCase{
        return GetUsersUseCase(userRepository)
    }
    @Provides
    fun provideGetPostsUseCase(userRepository: UserRepository): GetUsersPostsUseCase{
        return GetUsersPostsUseCase(userRepository)
    }

    @Provides
    fun provideGetUsersPostsByIdUseCase(userRepository: UserRepository): GetUsersPostsByIdUseCase{
        return GetUsersPostsByIdUseCase(userRepository)
    }

}