package com.example.measurementmultitool.ui.currencies


sealed class CurrenciesAction {
    data class Number(val number: Int): CurrenciesAction()
    object Clear: CurrenciesAction()
    object Decimal: CurrenciesAction()
    object Delete: CurrenciesAction()
    object Calculate: CurrenciesAction()
}