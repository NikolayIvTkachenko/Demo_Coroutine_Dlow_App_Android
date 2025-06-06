package com.example.coroutineflowdemoapp.presenter.view_model

import com.example.coroutineflowdemoapp.presenter.model.TaskUi

data class DemoListTasksState(
    val listIds: List<TaskUi>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)