package com.example.qrscannerapp.data

import android.content.Context
import androidx.room.Room
import com.example.qrscannerapp.domain.repository.QrRepository

object Graph {
    lateinit var database: QrDatabase

    val qrRepository by lazy {
        QrRepository(qrDao = database.qrDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(
            context = context,
            klass = QrDatabase::class.java,
            name = "qr.db"
        ).build()
    }
}