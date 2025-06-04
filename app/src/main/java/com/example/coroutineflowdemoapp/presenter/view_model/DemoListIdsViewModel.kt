package com.example.coroutineflowdemoapp.presenter.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRawRepository
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DemoListIdsViewModel @Inject constructor(
    private val repository: DemoTasksRepository,
    private val repositoryRaw: DemoTasksRawRepository,
): ViewModel() {

    //Метод, который вызывает список идентификаторов
    fun getIdsInResource() {
        println("DemoListIdsViewModel getIdsInResource()")
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            println()
            val ids = repository.getListIds()
            val endTime = System.currentTimeMillis()
            val timeWork = endTime - startTime
            println("startTime = $startTime")
            println("endTime = $endTime")
            println("timeWork = $timeWork")
            println("ids = $ids")
        }
    }

    //Метод, который вызывает список идентификаторов, в обертке
    fun getIdsRaw() {
        println("DemoListIdsViewModel getIdsRaw")
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            println()
            val ids = repositoryRaw.getListIds()
            val endTime = System.currentTimeMillis()
            val timeWork = endTime - startTime
            println("startTime = $startTime")
            println("endTime = $endTime")
            println("timeWork = $timeWork")
            println("ids = $ids")
        }
    }

    //Тестирование работы корутин, последовательная работа
    fun getTest01() {

    }

    //Тстирование работы корутин, паралельная работа
    fun getTest02() {

    }

    //Тестирование работы корутин/флоу, последовательная работа
    fun getTest03() {

    }

    //Тстирование работы корутин/флоу, паралельная работа
    fun getTest04() {

    }
}