package com.example.measurementmultitool.ui.currencies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.measurementmultitool.MeasurementMultiToolApplication
import com.example.measurementmultitool.data.CurrenciesRepository
import kotlinx.coroutines.launch


class CurrenciesViewModel(
    private val currenciesRepository: CurrenciesRepository
) : ViewModel() {

    var uiState by mutableStateOf(CurrencyUiState())
        private set

    init {
        getRate()
    }

    fun onAction(action: CurrenciesAction) {
        when (action) {
            is CurrenciesAction.Number -> enterNumber(action.number)
            is CurrenciesAction.Clear -> uiState =
                CurrencyUiState(baseCurrency = uiState.baseCurrency, outputCurrency = uiState.outputCurrency, rate = uiState.rate)
            is CurrenciesAction.Decimal -> enterDecimal()
            is CurrenciesAction.Delete -> performDeletion()
            is CurrenciesAction.Calculate -> performCalculation()
        }
    }

    private fun enterNumber(number: Int) {
        if (uiState.inputAmount.length >= MAX_NUM_LENGTH)
            return

        uiState = uiState.copy(
            inputAmount = uiState.inputAmount + number
        )
    }

    private fun enterDecimal() {
        if (!uiState.inputAmount.contains(".") && uiState.inputAmount.isNotBlank()) {
            uiState = uiState.copy(
                inputAmount = uiState.inputAmount + "."
            )
        }
    }

    private fun performDeletion() {
        if (uiState.inputAmount != "")
            uiState = uiState.copy(
                inputAmount = uiState.inputAmount.dropLast(1)
            )
    }

    private fun performCalculation() {
        val inputAmount = uiState.inputAmount.toDoubleOrNull()
        val rate = uiState.rate

        if (inputAmount == null) {
            return
        }

        uiState = uiState.copy(
            outputAmount = (inputAmount.times(rate)).toString().take(6)
        )
    }

    fun selectBaseCurrency(currency: String) {
        uiState = uiState.copy(
            baseCurrency = currency
        )

        getRate()
    }

    fun selectOutputCurrency(currency: String) {
        uiState = uiState.copy(
            outputCurrency = currency
        )

        getRate()
    }

    fun getRate() {
        viewModelScope.launch {
            try {
                val rate = currenciesRepository.getCurrencyRate(
                    baseCurrency = uiState.baseCurrency,
                    outputCurrency = uiState.outputCurrency
                )
                uiState = uiState.copy(
                    rate = rate[0].rate
                )

            } catch (_: Exception) {

            }
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MeasurementMultiToolApplication)
                val currenciesRepository = application.container.currenciesRepository
                CurrenciesViewModel(currenciesRepository = currenciesRepository)
            }
        }
    }
}