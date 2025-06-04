package com.example.coroutineflowdemoapp.presenter.model

import com.example.coroutineflowdemoapp.domain.model.Task
import java.util.Date

data class TaskUi(
    val idTask: String,
    val nameTask: String?,
    val dateCreate: Date?,
    val author: String?,
) {
    constructor(task: Task): this(
        idTask = task.idTask,
        nameTask = task.nameTask,
        dateCreate = task.dateCreate,
        author = task.author,
    )
}