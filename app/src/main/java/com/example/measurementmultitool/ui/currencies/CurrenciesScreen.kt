package com.example.measurementmultitool.ui.currencies

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.measurementmultitool.ui.MeasurementMultiToolTopAppBar


@Composable
fun CurrenciesScreen(
    currenciesViewModel: CurrenciesViewModel = viewModel(factory = CurrenciesViewModel.Factory),
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState = currenciesViewModel.uiState

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        topBar = {
            MeasurementMultiToolTopAppBar(
                title = "Currency Converter",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .fillMaxSize(),
        ) {
            CurrenciesTextArea(
                selectedCurrency = uiState.baseCurrency,
                onCurrencySelected = {
                    currenciesViewModel.selectBaseCurrency(it.takeLast(3))

                    if (uiState.outputAmount != "")
                        currenciesViewModel.onAction(CurrenciesAction.Calculate)
                },
                text = uiState.inputAmount,
                modifier = Modifier.padding(
                    top = 24.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 16.dp
                )
            )
            CurrenciesTextArea(
                selectedCurrency = uiState.outputCurrency,
                onCurrencySelected = {
                    currenciesViewModel.selectOutputCurrency(it.takeLast(3))

                    if (uiState.inputAmount != "")
                        currenciesViewModel.onAction(CurrenciesAction.Calculate)
                },
                text = uiState.outputAmount,
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 96.dp
                )
            )
            Row(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CurrenciesButton(
                    buttonText = "C",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Clear)
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "⌫",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Delete)
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CurrenciesButton(
                    buttonText = "7",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(7))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "8",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(8))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "9",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(9))
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CurrenciesButton(
                    buttonText = "4",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(4))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "5",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(5))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "6",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(6))
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CurrenciesButton(
                    buttonText = "1",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(1))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "2",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(2))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "3",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(3))
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CurrenciesButton(
                    buttonText = ".",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Decimal)
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "0",
                    onClick = {
                        currenciesViewModel.onAction(CurrenciesAction.Number(0))
                    },
                    modifier = Modifier.weight(1f)
                )
                CurrenciesButton(
                    buttonText = "=",
                    onClick = {
                        currenciesViewModel.getRate()
                        currenciesViewModel.onAction(CurrenciesAction.Calculate)
                    },
                    hexColor = 0xffAAC6EF,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Rates are provided by FreecurrencyAPI",
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun CurrenciesTextArea(
    selectedCurrency: String,
    onCurrencySelected: (String) -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(28.dp))
            .background(Color(0xFF1C1C1E)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CurrenciesDropDownList(
            selectedCurrency = selectedCurrency,
            onCurrencySelected = onCurrencySelected,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = selectedCurrency,
                fontSize = 16.sp,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(end = 48.dp)
            )
        }
    }
}

@Composable
fun CurrenciesDropDownList(
    selectedCurrency: String,
    onCurrencySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val currencies = listOf("US Dollar, USD", "Euro, EUR", "Japanese yen, JPY", "British pound, GBP", "Australian dollar, AUD", "Canadian dollar, CAD", "Swiss franc, CHF")

    Box(
        modifier = modifier
            .height(56.dp)
            .width(68.dp)
            .background(Color(0xFF6C6C70), shape = CircleShape)
            .clickable { expanded = true },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedCurrency,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier.padding(
                    start = 4.dp,
                    end = 2.dp
                )
            )
            if (expanded) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    contentDescription = "Expand"
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Collapse"
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            currencies.forEach { currency ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = currency
                        )
                    },
                    onClick = {
                        onCurrencySelected(currency)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CurrenciesButton(
    buttonText: String,
    onClick: () -> Unit,
    hexColor: Long = 0xffE4E5E9,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(26.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(hexColor)
        ),
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xff242728)
        )
    }
}