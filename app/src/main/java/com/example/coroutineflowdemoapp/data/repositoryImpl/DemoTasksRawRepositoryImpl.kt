package com.example.coroutineflowdemoapp.data.repositoryImpl

import com.example.coroutineflowdemoapp.data.network.DemoTasksApi
import com.example.coroutineflowdemoapp.domain.model.Task
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRawRepository
import javax.inject.Inject

class DemoTasksRawRepositoryImpl @Inject constructor(
    private val api: DemoTasksApi
): DemoTasksRawRepository {

    override suspend fun getListIds(): List<String> {
        return api.getListIds()
    }

    override suspend fun getListTask(): List<Task> {
        return api.getListTask().map { item ->
            item.toTasks()
        }
    }

    override suspend fun getTask(id: String): Task {
        return api.getTask(id).toTasks()
    }

    override suspend fun getPageListIds(offset: Int, limit: Int): List<String> {
        return api.getPageListIds(offset, limit)
    }

    override suspend fun getPageListTasks(offset: Int, limit: Int): List<Task> {
        return api.getPageListTasks(offset, limit).map { item ->
            item.toTasks()
        }
    }
}