package com.example.qrscannerapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class QrDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addQr(qrEntity:QrCode)

    @Query("SELECT * FROM qr ORDER BY dateTime DESC")
    abstract fun getHistory():Flow<List<QrCode>>

}