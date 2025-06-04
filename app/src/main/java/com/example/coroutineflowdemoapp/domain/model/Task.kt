package com.example.coroutineflowdemoapp.domain.model

import java.util.Date


data class Task(
    val idTask: String,
    val nameTask: String?,
    val dateCreate: Date?,
    val author: String?,
)
