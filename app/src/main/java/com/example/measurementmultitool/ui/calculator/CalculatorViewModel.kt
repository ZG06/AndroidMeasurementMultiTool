package com.example.measurementmultitool.ui.calculator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.os.registerForAllProfilingResults
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var uiState by mutableStateOf(CalculatorUiState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Clear -> uiState = CalculatorUiState()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (uiState.number1.isNotBlank()) {
            uiState = uiState.copy(operation = operation)
        }
    }

    private fun enterNumber(number: Int) {
        if (uiState.operation == null) {
            if (uiState.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            uiState = uiState.copy(
                number1 = uiState.number1 + number,
            )
            return
        }
        if (uiState.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        uiState = uiState.copy(
            number2 = uiState.number2 + number
        )
    }

    private fun performDeletion() {
        when {
            uiState.number2.isNotBlank() -> uiState = uiState.copy(
                number2 = uiState.number2.dropLast(1)
            )
            uiState.operation != null -> uiState = uiState.copy(
                operation = null
            )
            uiState.number1.isNotBlank() -> uiState = uiState.copy(
                number1 = uiState.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if (uiState.operation == null && !uiState.number1.contains(".")
            && uiState.number1.isNotBlank()) {
            uiState = uiState.copy(
                number1 = uiState.number1 + "."
            )
            return
        }
        if (!uiState.number2.contains(".") && uiState.number2.isNotBlank()) {
            uiState = uiState.copy(
                number2 = uiState.number2 + "."
            )
        }
    }

    private fun performCalculation() {
        val number1 = uiState.number1.toDoubleOrNull()
        val number2 = uiState.number2.toDoubleOrNull()

        if (number1 != null && number2 != null && uiState.operation != null) {
            val result = when (uiState.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }.toString().take(10)


            uiState = uiState.copy(
                number1 = result,
                number2 = "",
                operation = null
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}