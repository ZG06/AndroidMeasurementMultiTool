package com.example.measurementmultitool.ui.currencies

data class CurrencyUiState(
    val baseCurrency: String = "USD",
    val inputAmount: String = "",
    val outputCurrency: String = "EUR",
    val outputAmount: String = "",
    val rate: Double = 0.0
)