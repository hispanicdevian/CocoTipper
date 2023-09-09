package com.example.cocotipper.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CocoTipperScreen(viewModel: CocoTipperViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val cocoTipperModel = viewModel.cocoTipperModel.value

    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .paddingFromBaseline(100.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    // Title text here
                    Text(
                        text = "Lazy Tip",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold,
                            fontSize = 50.sp
                        ),
                    )
                }
                OutlinedTextField(
                    value = cocoTipperModel.baseAmount,
                    onValueChange = { viewModel.onBaseAmountChange(it) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    singleLine = true,
                    label = { Text(text = "Enter Amount") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .paddingFromBaseline(90.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(30.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TipButton(text = "15%", onClick = { viewModel.onTipPercentageChange(0.15) })
                    TipButton(text = "20%", onClick = { viewModel.onTipPercentageChange(0.20) })
                    TipButton(text = "25%", onClick = { viewModel.onTipPercentageChange(0.25) })
                }

                Spacer(modifier = Modifier.height(16.dp))

                TipResult(
                    baseAmount = cocoTipperModel.baseAmount.toDoubleOrNull() ?: 0.0,
                    tipPercentage = cocoTipperModel.tipPercentage
                )
            }
        }
    }
}