package com.example.measurementmultitool.ui.temperature

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.measurementmultitool.MeasurementMultiToolTopAppBar
import com.example.measurementmultitool.ui.theme.MeasurementMultiToolTheme


@Composable
fun TemperatureScreen(
    temperatureViewModel: TemperatureViewModel = viewModel(),
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState = temperatureViewModel.uiState

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = modifier,
        topBar = {
            MeasurementMultiToolTopAppBar(
                title = "Temperature Converter",
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
            TemperatureTextArea(
                selectedUnit = uiState.inputUnit,
                onUnitSelected = {
                    temperatureViewModel.selectInputUnit(it)

                    if (uiState.inputTemperature != "")
                        temperatureViewModel.onAction(TemperatureAction.Calculate)
                },
                text = (uiState.inputTemperature).toString(),
                modifier = Modifier.padding(
                    top = 24.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 16.dp
                )
            )
            TemperatureTextArea(
                selectedUnit = uiState.outputUnit,
                onUnitSelected = {
                    temperatureViewModel.selectOutputUnit(it)

                    if (uiState.inputTemperature != "")
                        temperatureViewModel.onAction(TemperatureAction.Calculate)
                },
                text = (uiState.outputTemperature).toString(),
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
                TemperatureButton(
                    buttonText = "C",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Clear)
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "⌫",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Delete)
                    },
                    modifier = Modifier.weight(2f)
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
                TemperatureButton(
                    buttonText = "7",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(7))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "8",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(8))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "9",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(9))
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
                TemperatureButton(
                    buttonText = "4",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(4))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "5",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(5))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "6",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(6))
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
                TemperatureButton(
                    buttonText = "1",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(1))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "2",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(2))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "3",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(3))
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
                TemperatureButton(
                    buttonText = ".",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Decimal)
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "0",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Number(0))
                    },
                    modifier = Modifier.weight(1f)
                )
                TemperatureButton(
                    buttonText = "=",
                    onClick = {
                        temperatureViewModel.onAction(TemperatureAction.Calculate)
                    },
                    hexColor = 0xffAAC6EF,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun TemperatureTextArea(
    selectedUnit: String,
    onUnitSelected: (String) -> Unit,
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
        TemperatureDropDownList(
            selectedUnit = selectedUnit,
            onUnitSelected = onUnitSelected,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = when (selectedUnit) {
                    "°C" -> "Celsius"
                    "°F" -> "Fahrenheit"
                    "°K" -> "Kelvin"
                    else -> ""
                },
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
fun TemperatureDropDownList(
    selectedUnit: String,
    onUnitSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val units = listOf("°C", "°F", "°K")

    Box(
        modifier = modifier
            .height(56.dp)
            .width(68.dp)
            .background(Color(0xFF6C6C70), shape = CircleShape)
            .clickable { expanded = true },
        contentAlignment = Alignment.Center
    ) {
        Row {
            Text(
                text = selectedUnit,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 4.dp)
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
            units.forEach { unit ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = when (unit) {
                                "°C" -> "Celsius"
                                "°F" -> "Fahrenheit"
                                "°K" -> "Kelvin"
                                else -> ""
                            }
                        )
                    },
                    onClick = {
                        onUnitSelected(unit)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun TemperatureButton(
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

@Preview()
@Composable
fun TemperatureTextAreaPreview() {
    MeasurementMultiToolTheme {
        TemperatureScreen(
            navigateBack = {}
        )
    }
}