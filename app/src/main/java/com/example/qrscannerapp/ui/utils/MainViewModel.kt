package com.example.qrscannerapp.ui.utils

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrscannerapp.data.Graph
import com.example.qrscannerapp.data.QrCode
import com.example.qrscannerapp.domain.repository.QrRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(
    private val _qrRepository:QrRepository = Graph.qrRepository
):ViewModel() {
    private val _textResult = mutableStateOf("")
    val textResult = _textResult

    lateinit var history:Flow<List<QrCode>>

    init {
        viewModelScope.launch {
            history = _qrRepository.getHistory()
        }
    }

    fun addQr(qrCode: QrCode){
        viewModelScope.launch {
            _qrRepository.addQr(qrCode)
        }
    }

    fun changeResult(result:String){
        _textResult.value = result
    }
}