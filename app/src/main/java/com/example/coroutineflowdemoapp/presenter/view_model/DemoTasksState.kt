package com.example.coroutineflowdemoapp.presenter.view_model

import com.example.coroutineflowdemoapp.presenter.model.TaskUi

data class DemoTasksState(
    val taskui: TaskUi,
    val isLoading: Boolean = false,
    val error: String? = null
)