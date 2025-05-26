package com.example.measurementmultitool.ui.test

import com.example.measurementmultitool.ui.temperature.TemperatureAction
import com.example.measurementmultitool.ui.temperature.TemperatureViewModel
import junit.framework.Assert.assertEquals
import org.junit.Test


class TemperatureViewModelTest {
    private val viewModel = TemperatureViewModel()

    @Test
    fun viewModel_temperatureActionNumber_InputTemperatureAddNumber() {
        // Changing inputTemperature to 1
        viewModel.onAction(TemperatureAction.Number(1))

        // Asserting that the inputTemperature is 1
        assertEquals(viewModel.uiState.inputTemperature, "1")
    }

    @Test
    fun viewModel_temperatureActionNumber_InputTemperatureNoNumbersAddedMaxLengthError() {
        // Changing inputTemperature to 12345678
        viewModel.onAction(TemperatureAction.Number(12345678))
        // Adding a 9th symbol
        viewModel.onAction(TemperatureAction.Number(9))

        // Asserting that no numbers are added to the inputTemperature if it's length is 8
        assertEquals(viewModel.uiState.inputTemperature, "12345678")
    }

    @Test
    fun viewModel_temperatureActionClear_InputTemperatureClear() {
        // Changing inputTemperature to 1
        viewModel.onAction(TemperatureAction.Number(1))
        // Clearing the inputTemperature
        viewModel.onAction(TemperatureAction.Clear)

        // Asserting that the inputTemperature is blank
        assertEquals(viewModel.uiState.inputTemperature, "")
    }

    @Test
    fun viewModel_temperatureActionMinus_InputTemperatureAddMinus() {
        // Changing inputTemperature to a minus
        viewModel.onAction(TemperatureAction.Minus)

        // Asserting that the inputTemperature is 1
        assertEquals(viewModel.uiState.inputTemperature, "-")
    }

    @Test
    fun viewModel_temperatureActionMinus_InputTemperatureNoMinusAddedIfNotTheFirstSymbol() {
        // Changing inputTemperature to 1
        viewModel.onAction(TemperatureAction.Number(1))
        // Adding a minus to the inputTemperature
        viewModel.onAction(TemperatureAction.Minus)

        // Asserting that the inputTemperature is 1 and the minus was not added
        assertEquals(viewModel.uiState.inputTemperature, "1")
    }

    @Test
    fun viewModel_temperatureActionDecimal_InputTemperatureAddDecimal() {
        // Changing inputTemperature to 1
        viewModel.onAction(TemperatureAction.Number(1))
        // Adding a decimal point to the inputTemperature
        viewModel.onAction(TemperatureAction.Decimal)

        // Asserting that the inputTemperature is 1
        assertEquals(viewModel.uiState.inputTemperature, "1.")
    }

    @Test
    fun viewModel_temperatureActionDecimal_InputTemperatureDecimalUpdateIfNotFirstSymbol() {
        // Changing inputTemperature to a decimal point
        viewModel.onAction(TemperatureAction.Decimal)

        // Assert that the inputTemperature is "" if the decimal point is the first symbol
        assertEquals(viewModel.uiState.inputTemperature, "")
    }

    @Test
    fun viewModel_temperatureActionDecimal_InputTemperatureDecimalUpdateIfContainsDecimalPoints() {
        // Changing inputTemperature to 1
        viewModel.onAction(TemperatureAction.Number(1))
        // Adding a decimal point to the inputTemperature
        viewModel.onAction(TemperatureAction.Decimal)
        // Adding another decimal point to the inputTemperature
        viewModel.onAction(TemperatureAction.Decimal)

        // Assert that the inputTemperature is "1." and the other decimal point wan not added
        assertEquals(viewModel.uiState.inputTemperature, "1.")
    }

    @Test
    fun viewModel_temperatureActionDelete_InputTemperatureDeleteLastSymbol() {
        // Changing inputTemperature to 12
        viewModel.onAction(TemperatureAction.Number(12))

        // Deleting last number
        viewModel.onAction(TemperatureAction.Delete)

        // Assert that the inputTemperature is "" if the decimal point is the first symbol
        assertEquals(viewModel.uiState.inputTemperature, "1")
    }

    @Test
    fun viewModel_temperatureActionDelete_InputTemperatureNoSymbolsToDelete() {
        // Deleting last number when there is nothing to delete
        viewModel.onAction(TemperatureAction.Delete)

        // Assert that the inputTemperature is "" if the decimal point is the first symbol
        assertEquals(viewModel.uiState.inputTemperature, "")
    }

    @Test
    fun viewModel_temperatureActionCalculate_selectInputUnit() {
        // Changing an inputUnit to °F
        viewModel.selectInputUnit("°F")

        // Asserting that the inputUnit is °F
        assertEquals(viewModel.uiState.inputUnit, "°F")
    }

    @Test
    fun viewModel_temperatureActionCalculate_selectOutputUnit() {
        // Changing an inputUnit to °F
        viewModel.selectOutputUnit("°K")

        // Asserting that the inputUnit is °F
        assertEquals(viewModel.uiState.outputUnit, "°K")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateCelsiusToCelsius() {
        viewModel.selectInputUnit("°C")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°C")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "1.0")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateCelsiusToFahrenheit() {
        viewModel.selectInputUnit("°C")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°F")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "33.8")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateCelsiusToKelvin() {
        viewModel.selectInputUnit("°C")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°K")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "274.15")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateFahrenheitToCelsius() {
        viewModel.selectInputUnit("°F")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°C")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "-17.22")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateFahrenheitToFahrenheit() {
        viewModel.selectInputUnit("°F")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°F")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "1.0")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateFahrenheitToKelvin() {
        viewModel.selectInputUnit("°F")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°K")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "255.92")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateKelvinToCelsius() {
        viewModel.selectInputUnit("°K")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°C")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "-272.1")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateKelvinToFahrenheit() {
        viewModel.selectInputUnit("°K")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°F")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "-457.8")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureUpdateKelvinToKelvin() {
        viewModel.selectInputUnit("°K")
        viewModel.onAction(TemperatureAction.Number(1))
        viewModel.selectOutputUnit("°K")
        viewModel.onAction(TemperatureAction.Calculate)

        assertEquals(viewModel.uiState.outputTemperature, "1.0")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureForNullTemperature() {
        // Calculating empty temperature
        viewModel.onAction(TemperatureAction.Calculate)

        // Asserting that the outputTemperature is blank
        assertEquals(viewModel.uiState.outputTemperature, "")
    }

    @Test
    fun viewModel_temperatureActionCalculate_OutputTemperatureForMinusSign() {
        // Calculating a minus sign
        viewModel.onAction(TemperatureAction.Minus)
        viewModel.onAction(TemperatureAction.Calculate)

        // Asserting that the outputTemperature is blank
        assertEquals(viewModel.uiState.outputTemperature, "")
    }
}