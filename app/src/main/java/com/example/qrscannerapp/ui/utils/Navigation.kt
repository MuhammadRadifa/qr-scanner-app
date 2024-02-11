package com.example.qrscannerapp.ui.utils

import com.example.qrscannerapp.R

data class NavigationItem(
    val title:String,
    val icon:Int,
)

val itemNavigation = listOf<NavigationItem>(
    NavigationItem(
        title = "Generate",
        icon = R.drawable.qr_scanner
    ),
    NavigationItem(
        title = "History",
        icon = R.drawable.history
    )
)