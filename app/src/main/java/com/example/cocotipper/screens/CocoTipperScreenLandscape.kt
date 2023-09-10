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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cocotipper.subscreens.TipButton
import com.example.cocotipper.subscreens.TipResult
import com.example.cocotipper.viewmodel.CocoTipperViewModel

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CocoTipperScreenLandscape(viewModel: CocoTipperViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val cocoTipperModel = viewModel.cocoTipperModel.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text("Coco Tipper",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = cocoTipperModel.baseAmount,
                onValueChange = { viewModel.onBaseAmountChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textStyle = LocalTextStyle.current,
                singleLine = true,
                placeholder = { Text("Enter Amount") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { keyboardController?.hide() }
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
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

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}