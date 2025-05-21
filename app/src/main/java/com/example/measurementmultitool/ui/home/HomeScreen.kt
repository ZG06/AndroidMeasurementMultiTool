package com.example.measurementmultitool.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.measurementmultitool.MeasurementMultiToolTopAppBar
import com.example.measurementmultitool.R
import com.example.measurementmultitool.ui.theme.MeasurementMultiToolTheme


@Composable
fun HomeScreen(
    onCalculatorClick: () -> Unit,
    onCurrencyConverterClick: () -> Unit,
    onTemperatureConverterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            MeasurementMultiToolTopAppBar(
                title = stringResource(R.string.app_name),
                canNavigateBack = false
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(28.dp),
            verticalArrangement = Arrangement.spacedBy(28.dp),
            modifier = Modifier.padding(16.dp),
            contentPadding = innerPadding
        ) {
            item {
                Card(
                    onClick = onCalculatorClick,
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    modifier = Modifier.aspectRatio(1f)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.calculator_icon),
                            contentDescription = "Calculator",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(bottom = 18.dp)
                                .size(64.dp)
                        )
                        Text(
                            text = "Calculator",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            item {
                Card(
                    onClick = onCurrencyConverterClick,
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    modifier = Modifier.aspectRatio(1f)

                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.currency_converter),
                            contentDescription = "Currency Converter",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(bottom = 18.dp)
                                .size(64.dp)
                        )
                        Text(
                            text = "Currency Converter",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            item {
                Card(
                    onClick = onTemperatureConverterClick,
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    modifier = Modifier.aspectRatio(1f)

                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.temperature_converter),
                            contentDescription = "Temperature Converter",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(bottom = 18.dp)
                                .size(64.dp)
                        )
                        Text(
                            text = "Temperature Converter",
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MeasurementMultiToolTheme {
        HomeScreen(
            onCalculatorClick = {},
            onCurrencyConverterClick = {},
            onTemperatureConverterClick = {}
        )
    }
}