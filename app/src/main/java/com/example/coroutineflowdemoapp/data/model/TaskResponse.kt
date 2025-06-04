package com.example.coroutineflowdemoapp.data.model

import com.example.coroutineflowdemoapp.domain.model.Task
import com.example.coroutineflowdemoapp.utils.ConvertData
import com.squareup.moshi.Json

data class TaskResponse(
    @field:Json(name = "idTask")
    val idTask: String,
    @field:Json(name = "nameTask")
    val nameTask: String?,
    @field:Json(name = "dateCreate")
    val dateCreate: String?,
    @field:Json(name = "author")
    val author: String?,
) {
    fun toTasks(): Task {
        val task: Task = Task(
            idTask = idTask,
            nameTask = nameTask,
            dateCreate = dateCreate?.let {ConvertData.convertStringToDateDate(it)},
            author = author,
        )
        return task
    }
}

//-------------
//{
//"idTask": "Task_0005",
//"nameTask": "Create password page",
//"dateCreate": "2025-06-04T06:47:47.567+00:00",
//"author": "Nick"
//}
