package com.example.cocotipper.screens

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.cocotipper.viewmodel.CocoTipperViewModel

@Composable
fun CocoTipperScreen(viewModel: CocoTipperViewModel) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    if (isPortrait) {
        CocoTipperScreenPortrait(viewModel)
    } else {
        CocoTipperScreenLandscape(viewModel)
    }
}
