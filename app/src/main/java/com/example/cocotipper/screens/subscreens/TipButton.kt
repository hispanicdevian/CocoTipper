package com.example.cocotipper.screens.subscreens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cocotipper.ui.theme.CocoShell

@Composable
fun TipButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            CocoShell,
        )
    ) {
        Text(text)
    }
}