package com.example.coroutineflowdemoapp.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coroutineflowdemoapp.presenter.screens.SampleTestScreen
import com.example.coroutineflowdemoapp.presenter.view_model.DemoListIdsViewModel
import com.example.coroutineflowdemoapp.presenter.view_model.DemoTasksViewModel
import com.example.coroutineflowdemoapp.ui.theme.CoroutineFlowDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutineFlowDemoAppTheme {
                MainScreeOnePage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreeOnePage() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Test Coroutine/Flow")
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            SampleTestScreen()
        }
    }
}

@Composable
fun MainScreenManyPage() {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview(

) {
    CoroutineFlowDemoAppTheme {
        MainScreeOnePage()
    }
}

//------------
//https://developer.android.com/develop/ui/compose/components/app-bars?hl=ru
//https://developer.android.com/develop/ui/compose/components/scaffold?hl=ru
//    //val demoListIdsViewModel: DemoListIdsViewModel by viewModels()
//    //val demoTasksViewModel: DemoTasksViewModel by viewModels()