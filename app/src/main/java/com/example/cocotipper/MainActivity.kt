package com.example.cocotipper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CocoTipperViewModel = viewModel()
            CocoTipperScreen(viewModel)
        }
    }
}

@Preview(showBackground = true)
