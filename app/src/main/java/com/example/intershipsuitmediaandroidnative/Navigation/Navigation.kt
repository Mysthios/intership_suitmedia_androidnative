package com.example.intershipsuitmediaandroidnative.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.intershipsuitmediaandroidnative.ui.screen.FirstScreen
import com.example.intershipsuitmediaandroidnative.ui.screen.SecondScreen
import com.example.intershipsuitmediaandroidnative.ui.screen.ThirdScreen
import com.example.intershipsuitmediaandroidnative.viewmodel.AppViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val appViewModel: AppViewModel = viewModel()

    NavHost(navController = navController, startDestination = "first") {
        composable("first") {
            FirstScreen(
                navController = navController,
                viewModel = appViewModel
            )
        }
        composable("second") {
            SecondScreen(
                navController = navController,
                viewModel = appViewModel
            )
        }
        composable("third") {
            ThirdScreen(
                navController = navController,
                viewModel = appViewModel
            )
        }
    }
}