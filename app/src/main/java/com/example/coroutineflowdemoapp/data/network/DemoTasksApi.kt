package com.example.coroutineflowdemoapp.data.network

import com.example.coroutineflowdemoapp.data.model.TaskResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DemoTasksApi {

    @GET("/tasks/ids")
    suspend fun getListIds(): List<String>

    @GET("/tasks/list")
    suspend fun getListTask(): List<TaskResponse>

    @GET("/tasks/{id}")
    suspend fun getTask(
        @Query("id") id: String
    ): TaskResponse

    //Pagination
    @GET("/tasks/page/ids")
    suspend fun getPageListIds(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): List<String>


    @GET("/tasks/page/list")
    suspend fun getPageListTasks(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): List<TaskResponse>

}