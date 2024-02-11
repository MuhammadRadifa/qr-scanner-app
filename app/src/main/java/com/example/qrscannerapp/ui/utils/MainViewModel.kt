package com.example.qrscannerapp.ui.utils

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val _textResult = mutableStateOf("")
    val textResult = _textResult

    fun changeResult(result:String){
        _textResult.value = result
    }
}