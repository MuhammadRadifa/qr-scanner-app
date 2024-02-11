package com.example.qrscannerapp.ui

import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.qrscannerapp.R
import com.example.qrscannerapp.ui.component.BottomBar
import com.example.qrscannerapp.ui.component.FloatingButton
import com.example.qrscannerapp.ui.component.TopBar
import com.example.qrscannerapp.ui.screen.HistoryScreen

@Composable
fun MainApp(){
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar()},
        floatingActionButton = { FloatingButton() },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = colorResource(id = R.color.blue_tertiary)
    ) {
        innerPadding ->
        HistoryScreen(innerPadding)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainAppPreview(){
    MainApp()
}