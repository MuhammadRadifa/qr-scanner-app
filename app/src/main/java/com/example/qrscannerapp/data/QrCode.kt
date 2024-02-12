package com.example.qrscannerapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qr")
data class QrCode(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name = "url")
    var url:String = "",
    @ColumnInfo(name = "dateTime")
    val dateTime:Long = System.currentTimeMillis()
)