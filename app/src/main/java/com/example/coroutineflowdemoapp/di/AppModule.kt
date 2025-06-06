package com.example.coroutineflowdemoapp.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.coroutineflowdemoapp.App
import com.example.coroutineflowdemoapp.ConstantApp
import com.example.coroutineflowdemoapp.data.network.DemoTasksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(ChuckerInterceptor(App.instance.applicationContext))
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(ConstantApp.base_url + "/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create()
    }
}