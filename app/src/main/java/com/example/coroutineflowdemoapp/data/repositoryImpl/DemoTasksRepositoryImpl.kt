package com.example.coroutineflowdemoapp.data.repositoryImpl

import com.example.coroutineflowdemoapp.data.network.DemoTasksApi
import com.example.coroutineflowdemoapp.domain.model.Task
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRepository
import com.example.coroutineflowdemoapp.domain.utils.Resource
import javax.inject.Inject

class DemoTasksRepositoryImpl @Inject constructor(
    private val api: DemoTasksApi
): DemoTasksRepository {

    override suspend fun getListIds(): Resource<List<String>> {
        return try {
            Resource.Success(
                data = api.getListIds()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Неизвестная ошибка возникла")
        }
    }

    override suspend fun getListTask(): Resource<List<Task>> {
        return try {
            Resource.Success(
                data = api.getListTask().map { item ->
                    item.toTasks()
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Неизвестная ошибка возникла")
        }
    }

    override suspend fun getTask(id: String): Resource<Task> {
        return try {
            Resource.Success(
                data = api.getTask(id).toTasks()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Неизвестная ошибка возникла")
        }
    }

    override suspend fun getPageListIds(offset: Int, limit: Int): Resource<List<String>> {
        return try {
            Resource.Success(
                data = api.getPageListIds(offset, limit)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Неизвестная ошибка возникла")
        }
    }

    override suspend fun getPageListTasks(offset: Int, limit: Int): Resource<List<Task>> {
        return try {
            Resource.Success(
                data = api.getPageListTasks(offset, limit).map { item ->
                    item.toTasks()
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Неизвестная ошибка возникла")
        }
    }
}