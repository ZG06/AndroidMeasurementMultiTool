package com.example.measurementmultitool.data

import com.example.measurementmultitool.network.CurrenciesApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val currenciesRepository: CurrenciesRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://api.freecurrencyapi.com/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: CurrenciesApiService by lazy {
        retrofit.create(CurrenciesApiService::class.java)
    }

    override val currenciesRepository: CurrenciesRepository by lazy {
        NetworkCurrenciesRepository(retrofitService)
    }
}