package com.example.measurementmultitool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.measurementmultitool.ui.calculator.CalculatorScreen
import com.example.measurementmultitool.ui.currencies.CurrenciesScreen
import com.example.measurementmultitool.ui.home.HomeScreen
import com.example.measurementmultitool.ui.temperature.TemperatureScreen


enum class MeasurementMultiToolScreen {
    Start,
    Calculator,
    CurrencyConverter,
    TemperatureConverter
}

@Composable
fun MultiToolNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MeasurementMultiToolScreen.Start.name,
        modifier = modifier
    ) {
        composable(route = MeasurementMultiToolScreen.Start.name) {
            HomeScreen(
                onCalculatorClick = {
                    navController.navigate(MeasurementMultiToolScreen.Calculator.name)
                },
                onCurrencyConverterClick = {
                    navController.navigate(MeasurementMultiToolScreen.CurrencyConverter.name)
                },
                onTemperatureConverterClick = {
                    navController.navigate(MeasurementMultiToolScreen.TemperatureConverter.name)
                }
            )
        }
        composable(route = MeasurementMultiToolScreen.Calculator.name) {
            CalculatorScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = MeasurementMultiToolScreen.CurrencyConverter.name) {
            CurrenciesScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(route = MeasurementMultiToolScreen.TemperatureConverter.name) {
            TemperatureScreen(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}