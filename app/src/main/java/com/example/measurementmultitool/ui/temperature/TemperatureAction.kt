package com.example.measurementmultitool.ui.temperature

sealed class TemperatureAction {
    data class Number(val number: Int): TemperatureAction()
    object Clear: TemperatureAction()
    object Decimal: TemperatureAction()
    object Delete: TemperatureAction()
    object Calculate: TemperatureAction()
}