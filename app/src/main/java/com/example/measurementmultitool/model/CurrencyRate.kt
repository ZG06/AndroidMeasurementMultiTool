package com.example.measurementmultitool.model

import kotlinx.serialization.Serializable


@Serializable
data class CurrencyRate(
    val data: Map<String, Double>
)