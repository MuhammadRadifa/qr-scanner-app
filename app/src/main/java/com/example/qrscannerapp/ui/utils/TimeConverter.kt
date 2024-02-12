package com.example.qrscannerapp.ui.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun TimeConverter(currentMillis:Long):String{
    val currentInstant = Instant.ofEpochMilli(currentMillis)
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy | HH:mm")
        .withZone(ZoneId.systemDefault())
    return formatter.format(currentInstant)
}