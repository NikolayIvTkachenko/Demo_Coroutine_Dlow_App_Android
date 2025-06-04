package com.example.coroutineflowdemoapp.presenter.ui_utils

sealed class Screens(val screen: String) {
    data object SampleTestScreen: Screens("test_screen")
    data object SimpleMainScreen: Screens("test_screen")
    data object SimpleRawMainScreen: Screens("test_screen")
    data object SimpleTaskListScreen: Screens("test_screen")
    data object SimpleRawTaskListScreen: Screens("test_screen")
    data object SimpleDescriptionTaskScreen: Screens("test_screen")
    data object SimpleRawDescriptionTaskScreen: Screens("test_screen")
}