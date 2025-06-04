package com.example.coroutineflowdemoapp.presenter.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coroutineflowdemoapp.presenter.view_model.DemoListIdsViewModel
import com.example.coroutineflowdemoapp.presenter.view_model.DemoTasksViewModel

@Composable
fun SimpleRawDescriptionTaskScreen(
    taskViewModel: DemoTasksViewModel = hiltViewModel(),
    listIdsViewModel: DemoListIdsViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {


    }
}