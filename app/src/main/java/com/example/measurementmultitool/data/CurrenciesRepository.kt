package com.example.measurementmultitool.data

import com.example.measurementmultitool.BuildConfig
import com.example.measurementmultitool.model.CurrencyItem
import com.example.measurementmultitool.model.CurrencyRate
import com.example.measurementmultitool.network.CurrenciesApiService


interface CurrenciesRepository {
    suspend fun getCurrencyRate(
        baseCurrency: String,
        outputCurrency: String
    ): List<CurrencyItem>
}

class NetworkCurrenciesRepository(
    private val currenciesApiService: CurrenciesApiService
) : CurrenciesRepository {

    override suspend fun getCurrencyRate(
        baseCurrency: String,
        outputCurrency: String
    ): List<CurrencyItem> {
        val response: CurrencyRate = currenciesApiService.getCurrencyRate(
            apiKey = BuildConfig.CURRENCY_API_KEY,
            baseCurrency = baseCurrency,
            outputCurrency = outputCurrency
        )

        return response.data.map { CurrencyItem(it.key, it.value) }
    }
}