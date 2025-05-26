package com.example.measurementmultitool.network

import com.example.measurementmultitool.model.CurrencyRate
import retrofit2.http.GET
import retrofit2.http.Query


interface CurrenciesApiService {

    @GET("latest")
    suspend fun getCurrencyRate(
        @Query("apikey") apiKey: String,
        @Query("base_currency") baseCurrency: String,
        @Query("currencies") outputCurrency: String
    ): CurrencyRate
}