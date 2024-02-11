package com.example.qrscannerapp.ui.utils

sealed class Screen(val route:String) {
    data object QrScreen:Screen("Qr_Screen")
    data object HistoryScreen:Screen("History_Screen")
    data object GenerateScreen:Screen("Generate_Screen")
}

val screenNavigation = mapOf<String,String>(
    "Qr" to Screen.QrScreen.route,
    "History" to Screen.HistoryScreen.route,
    "Generate" to Screen.HistoryScreen.route
)