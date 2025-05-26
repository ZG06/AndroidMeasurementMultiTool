package com.example.measurementmultitool.ui.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.measurementmultitool.ui.MeasurementMultiToolTopAppBar
import com.example.measurementmultitool.ui.theme.MeasurementMultiToolTheme


@Composable
fun CalculatorScreen(
    calculatorViewModel: CalculatorViewModel = viewModel(),
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState = calculatorViewModel.uiState

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        topBar = {
            MeasurementMultiToolTopAppBar(
                title = "Calculator",
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            CalculatorText(
                outputText = uiState.number1 + (uiState.operation?.symbol ?: "") + uiState.number2,
                modifier = Modifier.padding(
                    top = 64.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 96.dp
                )
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalculatorButton(
                    buttonText = "C",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Clear)
                    },
                    modifier = Modifier
                        .weight(1f)
                )
                CalculatorButton(
                    buttonText = "⌫",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Delete)
                    },
                    modifier = Modifier.weight(2f)
                )
                CalculatorButton(
                    buttonText = "÷",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    },
                    hexColor = 0xffD2E0F1,
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalculatorButton(
                    buttonText = "7",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(7))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "8",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(8))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "9",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(9))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "×",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    },
                    hexColor = 0xffD2E0F1,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalculatorButton(
                    buttonText = "4",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(4))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "5",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(5))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "6",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(6))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "−",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    },
                    hexColor = 0xffD2E0F1,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CalculatorButton(
                    buttonText = "1",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(1))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "2",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(2))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "3",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(3))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "+",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    },
                    hexColor = 0xffD2E0F1,
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
                CalculatorButton(
                    buttonText = ".",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Decimal)
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "0",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Number(0))
                    },
                    modifier = Modifier.weight(1f)
                )
                CalculatorButton(
                    buttonText = "=",
                    onClick = {
                        calculatorViewModel.onAction(CalculatorAction.Calculate)
                    },
                    hexColor = 0xffAAC6EF,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

// Calculator output
@Composable
fun CalculatorText(
    outputText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(24.dp))
    ) {
        Text(
            text = outputText,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.End,
            color = Color.Black,
            modifier = Modifier
                .padding(32.dp)
                .height(90.dp)
                .fillMaxWidth()
        )
    }
}

// Calculator buttons
@Composable
fun CalculatorButton(
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


@Preview
@Composable
fun CalculatorButtonPreview() {
    MeasurementMultiToolTheme {
        CalculatorButton(
            buttonText = "AC",
            onClick = {}
        )
    }
}