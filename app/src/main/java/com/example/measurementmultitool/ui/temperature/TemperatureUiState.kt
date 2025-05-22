package com.example.measurementmultitool.ui.temperature

data class TemperatureUiState(
    val inputUnit: String = "°C",
    val inputTemperature: String = "",
    val outputUnit: String = "°F",
    val outputTemperature: String = ""
)