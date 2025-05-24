package com.example.measurementmultitool.ui.temperature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class TemperatureViewModel : ViewModel() {
    var uiState by mutableStateOf(TemperatureUiState())
        private set

    fun onAction(action: TemperatureAction) {
        when (action) {
            is TemperatureAction.Number -> enterNumber(action.number)
            is TemperatureAction.Clear -> uiState = TemperatureUiState(inputUnit = uiState.inputUnit, outputUnit = uiState.outputUnit)
            is TemperatureAction.Minus -> addMinus()
            is TemperatureAction.Decimal -> enterDecimal()
            is TemperatureAction.Delete -> performDeletion()
            is TemperatureAction.Calculate -> performCalculation()
        }
    }

    private fun enterNumber(number: Int) {
        if (uiState.inputTemperature.length >= MAX_NUM_LENGTH)
            return

        uiState = uiState.copy(
            inputTemperature = uiState.inputTemperature + number
        )
    }

    private fun addMinus() {
        if (uiState.inputTemperature == "") {
            uiState = uiState.copy(
                inputTemperature = "-"
            )
        }
    }

    private fun enterDecimal() {
        if (!uiState.inputTemperature.contains(".") && uiState.inputTemperature.isNotBlank()) {
            uiState = uiState.copy(
                inputTemperature = uiState.inputTemperature + "."
            )
        }
    }

    private fun performDeletion() {
        if (uiState.inputTemperature != "")
            uiState = uiState.copy(
                inputTemperature = uiState.inputTemperature.dropLast(1)
            )
    }

    private fun performCalculation() {
        var inputTemp = uiState.inputTemperature.toDoubleOrNull()

        var outputTemp =
            when (uiState.inputUnit) {
                "°C" -> when (uiState.outputUnit) {
                    "°C" -> inputTemp
                    "°F" -> (inputTemp?.times(9)?.div(5)?.plus(32))
                    "°K" -> (inputTemp?.plus(273.15))
                    else -> null
                }
                "°F" -> when (uiState.outputUnit) {
                    "°C" -> ((inputTemp?.minus(32))?.times(5)?.div(9))
                    "°F" -> inputTemp
                    "°K" -> ((inputTemp?.minus(32))?.times(5)?.div(9)?.plus(273.15))
                    else -> null
                }
                "°K" -> when (uiState.outputUnit) {
                    "°C" -> (inputTemp?.minus(273.15))
                    "°F" -> ((inputTemp?.minus(273.15))?.times(9)?.div(5)?.plus(32))
                    "°K" -> inputTemp
                    else -> null
                }
                else -> null
            }.toString().take(6)

        if (inputTemp == null || inputTemp.toString() == "-") {
            return
        }

        uiState = uiState.copy(
            outputTemperature = outputTemp
        )
    }

    fun selectInputUnit(unit: String) {
        uiState = uiState.copy(
            inputUnit = unit
        )
    }

    fun selectOutputUnit(unit: String) {
        uiState = uiState.copy(
            outputUnit = unit
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}