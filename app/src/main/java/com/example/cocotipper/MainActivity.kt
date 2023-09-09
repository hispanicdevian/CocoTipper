package com.example.cocotipper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cocotipper.screens.CocoTipperScreen
import com.example.cocotipper.viewmodel.CocoTipperViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CocoTipperViewModel = viewModel()
            CocoTipperScreen(viewModel)
        }
    }
}
