package com.example.qrscannerapp

import android.app.Application
import com.example.qrscannerapp.data.Graph

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}