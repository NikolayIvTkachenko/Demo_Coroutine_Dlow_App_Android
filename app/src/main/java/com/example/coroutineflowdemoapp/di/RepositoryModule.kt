package com.example.coroutineflowdemoapp.di

import com.example.coroutineflowdemoapp.data.repositoryImpl.DemoTasksRawRepositoryImpl
import com.example.coroutineflowdemoapp.data.repositoryImpl.DemoTasksRepositoryImpl
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRawRepository
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDemoTasksRepository(
        demoTasksRepository: DemoTasksRepositoryImpl
    ): DemoTasksRepository


    @Binds
    @Singleton
    abstract fun bindDemoTasksRawRepository(
        demoTasksRawRepository: DemoTasksRawRepositoryImpl
    ): DemoTasksRawRepository

}