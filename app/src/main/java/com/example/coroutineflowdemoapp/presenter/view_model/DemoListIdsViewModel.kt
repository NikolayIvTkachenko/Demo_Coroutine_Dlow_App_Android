package com.example.coroutineflowdemoapp.presenter.view_model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineflowdemoapp.ConstantApp
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRawRepository
import com.example.coroutineflowdemoapp.domain.repository.DemoTasksRepository
import com.example.coroutineflowdemoapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DemoListIdsViewModel @Inject constructor(
    private val repository: DemoTasksRepository,
    private val repositoryRaw: DemoTasksRawRepository,
) : ViewModel() {

    var state by mutableStateOf(DemoIdsState())
        private set

    //Метод, который вызывает список идентификаторов
    fun getIdsInResource() {
        println("DemoListIdsViewModel getIdsInResource()")
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            val startTime = System.currentTimeMillis()
            println()
            val result = repository.getListIds()
            val endTime = System.currentTimeMillis()
            val timeWork = endTime - startTime
            println("startTime = $startTime")
            println("endTime = $endTime")
            println("timeWork = $timeWork")
            when (result) {
                is Resource.Success -> {
                    println("Resource.Success ->")
                    val ids = result.data
                    val message = result.message
                    println("ids = $ids")
                    println("message = $message")
                    state = state.copy(
                        listIds = ids,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    println("Resource.Error ->")
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                    )
                }
            }
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
        Log.d(ConstantApp.log_key_tni_help, "DemoListIdsViewModel getTest01() ")
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val startTime = System.currentTimeMillis()
                println()
                val ids = repositoryRaw.getListIds()
                Log.d(ConstantApp.log_key_tni_help, "ids = $ids")
                ids.map { id ->
                    try {
                        val item = repositoryRaw.getTask(id)
                        Log.d(ConstantApp.log_key_tni_help, " item = $item ")
                    } catch (e: Exception) {
                        Log.d(ConstantApp.log_key_tni_help, "item error = ${e.message}")
                    }

                }
                val endTime = System.currentTimeMillis()
                val timeWork = endTime - startTime
                Log.d(ConstantApp.log_key_tni_help, "startTime = $startTime")
                Log.d(ConstantApp.log_key_tni_help, "endTime = $endTime")
                Log.d(ConstantApp.log_key_tni_help, "timeWork = $timeWork")
            }
        } catch (e: Exception) {
            Log.d(ConstantApp.log_key_tni_help, "general error = ${e.message}")
        }
    }
    //startTime = 1749210483547
    //endTime = 1749210485199
    //timeWork = 1652

    //Тестирование работы корутин, паралельная работа
    fun getTest02() {
        Log.d(ConstantApp.log_key_tni_help, "DemoListIdsViewModel getTest02() ")
        try {
            val resultJob = viewModelScope.launch {
                val startTime = System.currentTimeMillis()
                val ids = repositoryRaw.getListIds()
                Log.d(ConstantApp.log_key_tni_help, "ids = $ids")
                ids.map { id ->
                    try {
                        var resultTask = async() {
                            val item = repositoryRaw.getTask(id)
                            Log.d(ConstantApp.log_key_tni_help, " item = $item ")
                        }
                        resultTask.await()
                    } catch (e: Exception) {
                        Log.d(ConstantApp.log_key_tni_help, "item error = ${e.message}")
                    }
                }
                val endTime = System.currentTimeMillis()
                val timeWork = endTime - startTime
                Log.d(ConstantApp.log_key_tni_help, "startTime = $startTime")
                Log.d(ConstantApp.log_key_tni_help, "endTime = $endTime")
                Log.d(ConstantApp.log_key_tni_help, "timeWork = $timeWork")
            }
        } catch (e: Exception) {
            Log.d(ConstantApp.log_key_tni_help, "general error = ${e.message}")
        }
    }

    //startTime = 1749221497786
    //endTime = 1749221498809
    //timeWork = 1023

    //Тестирование работы корутин, паралельная работа
    fun getTest03() {
        Log.d(ConstantApp.log_key_tni_help, "DemoListIdsViewModel getTest03() ")
        try {
            val resultJob = viewModelScope.launch {
                val startTime = System.currentTimeMillis()
                val ids = repositoryRaw.getListIds()
                Log.d(ConstantApp.log_key_tni_help, "ids = $ids")
                ids.map { id ->
                    var resultTask = async() {
                        val item = repositoryRaw.getTask(id)
                        Log.d(ConstantApp.log_key_tni_help, " item = $item ")
                    }
                    //Исключение выбрасывается, только при вызове await()
                    try {
                        resultTask.await()
                    } catch (e: Exception) {
                        Log.d(ConstantApp.log_key_tni_help, "item error = ${e.message}")
                    }
                }
                val endTime = System.currentTimeMillis()
                val timeWork = endTime - startTime
                Log.d(ConstantApp.log_key_tni_help, "startTime = $startTime")
                Log.d(ConstantApp.log_key_tni_help, "endTime = $endTime")
                Log.d(ConstantApp.log_key_tni_help, "timeWork = $timeWork")
            }
        } catch (e: Exception) {
            Log.d(ConstantApp.log_key_tni_help, "general error = ${e.message}")
        }
    }
    //startTime = 1749222169856
    //endTime = 1749222170880
    //timeWork = 1024

    //Тестирование работы корутин
    fun getTest04() {
        Log.d(ConstantApp.log_key_tni_help, "DemoListIdsViewModel getTest04() ")
        try {
            val resultJob = viewModelScope.launch(Dispatchers.IO) {
                val startTime = System.currentTimeMillis()
                val ids = repositoryRaw.getListIds()
                Log.d(ConstantApp.log_key_tni_help, "ids = $ids")
                ids.map { id ->
                    var resultTask = async(Dispatchers.IO) {
                        val item = repositoryRaw.getTask(id)
                        Log.d(ConstantApp.log_key_tni_help, " item = $item ")
                    }
                    //Исключение выбрасывается, только при вызове await()
                    try {
                        resultTask.await()
                    } catch (e: Exception) {
                        Log.d(ConstantApp.log_key_tni_help, "item error = ${e.message}")
                    }
                }
                val endTime = System.currentTimeMillis()
                val timeWork = endTime - startTime
                Log.d(ConstantApp.log_key_tni_help, "startTime = $startTime")
                Log.d(ConstantApp.log_key_tni_help, "endTime = $endTime")
                Log.d(ConstantApp.log_key_tni_help, "timeWork = $timeWork")
            }
        } catch (e: Exception) {
            Log.d(ConstantApp.log_key_tni_help, "general error = ${e.message}")
        }
    }
    //startTime = 1749222319867
    //endTime = 1749222320689
    //timeWork = 822

    //Тстирование работы корутин/флоу, паралельная работа
    fun getTest05() {
        Log.d(ConstantApp.log_key_tni_help, "DemoListIdsViewModel getTest04() ")
        try {
            val resultJob = viewModelScope.launch(Dispatchers.IO) {
                val startTime = System.currentTimeMillis()
                val ids = repositoryRaw.getListIds()
                Log.d(ConstantApp.log_key_tni_help, "ids = $ids")
                var asyncHashSet:LinkedHashSet<Deferred<Int>> = LinkedHashSet()
                ids.map { id ->
                    var resultTask = async(Dispatchers.IO) {
                        val item = repositoryRaw.getTask(id)
                        Log.d(ConstantApp.log_key_tni_help, " item = $item ")
                    }
                    asyncHashSet.add(resultTask)
                }

                //Исключение выбрасывается, только при вызове await()
                try {
                    asyncHashSet.map {
                        it.await()
                    }
                } catch (e: Exception) {
                    Log.d(ConstantApp.log_key_tni_help, "item error = ${e.message}")
                }
                val endTime = System.currentTimeMillis()
                val timeWork = endTime - startTime
                Log.d(ConstantApp.log_key_tni_help, "startTime = $startTime")
                Log.d(ConstantApp.log_key_tni_help, "endTime = $endTime")
                Log.d(ConstantApp.log_key_tni_help, "timeWork = $timeWork")
            }
        } catch (e: Exception) {
            Log.d(ConstantApp.log_key_tni_help, "general error = ${e.message}")
        }
    }
    //startTime = 1749222828530
    //endTime = 1749222829112
    //timeWork = 582

    fun getTest06() {
        Log.d(ConstantApp.log_key_tni_help, "DemoListIdsViewModel getTest04() ")
        val job = SupervisorJob()
        //Расширенная версия Job, которая предотвращает распространение ошибок от одной дочерней корутины к другим.
        //Если одна из дочерних корутин завершится с ошибкой, это не повлияет на другие дочерние корутины и SupervisorJob в целом.
        //Полезен в ситуациях, где задачи независимы друг от друга.
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d(ConstantApp.log_key_tni_help, "ignoring exception: ${throwable.javaClass.simpleName}")
        }
        val coroutineScope = CoroutineScope(job + Dispatchers.IO + exceptionHandler)


        try {
            val resultJob = coroutineScope.launch(Dispatchers.IO) {
                val startTime = System.currentTimeMillis()
                val ids = repositoryRaw.getListIds()
                Log.d(ConstantApp.log_key_tni_help, "ids = $ids")
                var asyncHashSet:LinkedHashSet<Deferred<Int>> = LinkedHashSet()
                ids.map { id ->
                    var resultTask = async(Dispatchers.IO) {
                        val item = repositoryRaw.getTask(id)
                        Log.d(ConstantApp.log_key_tni_help, " item = $item ")
                    }
                    asyncHashSet.add(resultTask)
                }

                //Исключение выбрасывается, только при вызове await()
                try {
                    asyncHashSet.map {
                        it.await()
                    }
                } catch (e: Exception) {
                    Log.d(ConstantApp.log_key_tni_help, "item error = ${e.message}")
                }
                val endTime = System.currentTimeMillis()
                val timeWork = endTime - startTime
                Log.d(ConstantApp.log_key_tni_help, "startTime = $startTime")
                Log.d(ConstantApp.log_key_tni_help, "endTime = $endTime")
                Log.d(ConstantApp.log_key_tni_help, "timeWork = $timeWork")
            }
        } catch (e: Exception) {
            Log.d(ConstantApp.log_key_tni_help, "general error = ${e.message}")
        }
    }
    //startTime = 1749229114616
    //endTime = 1749229115294
    //timeWork = 678
    //==>
    //startTime = 1749229137694
    //endTime = 1749229138102
    //timeWork = 408


    //Test Flow
    //******************************************************************************//





}