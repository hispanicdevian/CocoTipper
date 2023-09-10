package com.example.cocotipper.screens.subscreens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TipButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
    ) {
        Text(text)
    }
}
