package com.example.qrscannerapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [QrCode::class],
    version = 1,
    exportSchema = false
)

abstract class QrDatabase: RoomDatabase(){
    abstract fun qrDao():QrDao
}