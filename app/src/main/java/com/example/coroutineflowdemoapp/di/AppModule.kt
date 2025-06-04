package com.example.coroutineflowdemoapp.di

import com.example.coroutineflowdemoapp.ConstantApp
import com.example.coroutineflowdemoapp.data.network.DemoTasksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDemoTasksApi(): DemoTasksApi {
        return Retrofit.Builder()
            .baseUrl(ConstantApp.base_url + "/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}