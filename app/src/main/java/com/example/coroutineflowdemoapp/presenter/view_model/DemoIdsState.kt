package com.example.coroutineflowdemoapp.presenter.view_model

data class DemoIdsState(
    val listIds: List<String>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)