package com.example.coroutineflowdemoapp.domain.repository

import com.example.coroutineflowdemoapp.domain.model.Task

interface DemoTasksRawRepository {

    suspend fun getListIds(): List<String>

    suspend fun getListTask(): List<Task>

    suspend fun getTask(
        id: String
    ): Task

    //Pagination
    suspend fun getPageListIds(
        offset: Int,
        limit: Int,
    ): List<String>

    suspend fun getPageListTasks(
        offset: Int,
        limit: Int,
    ): List<Task>

}