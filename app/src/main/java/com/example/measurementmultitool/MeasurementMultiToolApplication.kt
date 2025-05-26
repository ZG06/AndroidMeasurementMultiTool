package com.example.measurementmultitool

import android.app.Application
import com.example.measurementmultitool.data.AppContainer
import com.example.measurementmultitool.data.DefaultAppContainer


class MeasurementMultiToolApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}