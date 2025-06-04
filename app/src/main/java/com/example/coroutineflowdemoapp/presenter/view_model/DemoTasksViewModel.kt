package com.example.coroutineflowdemoapp.presenter.view_model

import androidx.lifecycle.ViewModel
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRawRepository
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DemoTasksViewModel @Inject constructor(
    private val repository: DemoTasksRepository,
    private val repositoryRaw: DemoTasksRawRepository,
): ViewModel() {

}