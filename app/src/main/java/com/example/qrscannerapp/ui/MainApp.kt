package com.example.qrscannerapp.ui

import android.content.Context
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.qrscannerapp.R
import com.example.qrscannerapp.ui.component.BottomBar
import com.example.qrscannerapp.ui.component.FloatingButton
import com.example.qrscannerapp.ui.component.TopBar
import com.example.qrscannerapp.ui.screen.GenerateScreen
import com.example.qrscannerapp.ui.screen.HistoryScreen
import com.example.qrscannerapp.ui.screen.HomeScreen
import com.example.qrscannerapp.ui.utils.MainViewModel
import com.example.qrscannerapp.ui.utils.Screen

@Composable
fun MainApp(viewModel: MainViewModel,checkCameraPermission:()->Unit){
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        topBar = { TopBar(backStackEntry) },
        bottomBar = { BottomBar(navController,backStackEntry)},
        floatingActionButton = { FloatingButton(navController,checkCameraPermission) },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = colorResource(id = R.color.blue_tertiary)
    ) {
        innerPadding ->
        NavHost(navController = navController, startDestination = Screen.QrScreen.route ){
            composable(route = Screen.QrScreen.route){
                HomeScreen(innerPadding = innerPadding, viewModel = viewModel)
            }
            composable(route = Screen.HistoryScreen.route){
                HistoryScreen(innerPadding = innerPadding)
            }
            composable(route = Screen.GenerateScreen.route){
                GenerateScreen(innerPadding = innerPadding)
            }
        }
    }
}
