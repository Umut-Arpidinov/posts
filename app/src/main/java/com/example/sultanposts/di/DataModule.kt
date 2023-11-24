package com.example.sultanposts.di

import android.content.Context
import com.example.sultanposts.data.datasource.remote.UserRemoteDataSource
import com.example.sultanposts.data.datasource.remote.UserRemoteDataSourceImpl
import com.example.sultanposts.data.local.Preference
import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindUserRemoteDataSource(impl: UserRemoteDataSourceImpl): UserRemoteDataSource

}