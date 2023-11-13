package com.example.sultanposts.di

import com.example.sultanposts.data.datasource.remote.UserRemoteDataSource
import com.example.sultanposts.data.datasource.remote.UserRemoteDataSourceImpl
import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindUserRemoteDataSource(impl: UserRemoteDataSourceImpl): UserRemoteDataSource


}