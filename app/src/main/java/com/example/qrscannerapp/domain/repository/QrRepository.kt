package com.example.qrscannerapp.domain.repository

import com.example.qrscannerapp.data.QrCode
import com.example.qrscannerapp.data.QrDao
import kotlinx.coroutines.flow.Flow

class QrRepository(private val qrDao:QrDao) {

    suspend fun addQr(qrCode: QrCode){
        qrDao.addQr(qrCode)
    }

    fun getHistory():Flow<List<QrCode>> = qrDao.getHistory()

}