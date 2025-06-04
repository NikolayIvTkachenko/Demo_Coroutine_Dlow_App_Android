package com.example.coroutineflowdemoapp.presenter.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coroutineflowdemoapp.presenter.view_model.DemoListIdsViewModel
import com.example.coroutineflowdemoapp.presenter.view_model.DemoTasksViewModel

@Composable
fun SampleTestScreen(
    taskViewModel: DemoTasksViewModel = hiltViewModel(),
    listIdsViewModel: DemoListIdsViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Экран с проверкой работы запросов",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Button(
                    onClick = {
                        listIdsViewModel.getIdsRaw()
                    }
                ) {
                    Text(
                        text = "Just List of String",
                        fontSize = 12.sp
                    )
                }
                Button(
                    onClick = {
                        listIdsViewModel.getIdsInResource()
                    }
                ) {
                    Text(
                        text = "Wrapper List of String",
                        fontSize = 12.sp
                    )
                }
            }

        }
    }
}