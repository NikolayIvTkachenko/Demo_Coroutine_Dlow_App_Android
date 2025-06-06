package com.example.coroutineflowdemoapp.data.network

import com.example.coroutineflowdemoapp.data.model.TaskResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DemoTasksApi {

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("/tasks/ids")
    suspend fun getListIds(): List<String>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("/tasks/list")
    suspend fun getListTask(): List<TaskResponse>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("/tasks/{id}")
    suspend fun getTask(
        @Path("id") id: String
    ): TaskResponse

    //Pagination
    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("/tasks/page/ids/{offset}/{limit}")
    suspend fun getPageListIds(
        @Path("offset") offset: Int,
        @Path("limit") limit: Int,
    ): List<String>


    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("/tasks/page/list/{offset}/{limit}")
    suspend fun getPageListTasks(
        @Path("offset") offset: Int,
        @Path("limit") limit: Int,
    ): List<TaskResponse>

}