package com.example.measurementmultitool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.measurementmultitool.ui.calculator.CalculatorScreen
import com.example.measurementmultitool.ui.calculator.CalculatorViewModel
import com.example.measurementmultitool.ui.home.HomeScreen
import com.example.measurementmultitool.ui.theme.MeasurementMultiToolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeasurementMultiToolTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    MeasurementMultiToolApp()
                }
            }
        }
    }
}