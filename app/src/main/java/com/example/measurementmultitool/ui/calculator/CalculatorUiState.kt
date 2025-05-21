package com.example.measurementmultitool.ui.calculator

data class CalculatorUiState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)