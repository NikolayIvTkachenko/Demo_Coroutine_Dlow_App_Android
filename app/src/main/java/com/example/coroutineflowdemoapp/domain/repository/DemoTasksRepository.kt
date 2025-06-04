package com.example.coroutineflowdemoapp.domain.repository

import com.example.coroutineflowdemoapp.domain.model.Task
import com.example.coroutineflowdemoapp.domain.utils.Resource


interface DemoTasksRepository {

    suspend fun getListIds(): Resource<List<String>>

    suspend fun getListTask(): Resource<List<Task>>

    suspend fun getTask(
        id: String
    ): Resource<Task>

    //Pagination
    suspend fun getPageListIds(
        offset: Int,
        limit: Int,
    ): Resource<List<String>>

    suspend fun getPageListTasks(
        offset: Int,
        limit: Int,
    ): Resource<List<Task>>
}