package com.example.cocotipper.screens.subscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun TotalTip(baseAmount: Double, tipPercentage: Double) {
    val tipAmount = baseAmount * tipPercentage

    //This creates a limit for decimals shown
    val formattedTipAmount = "%.2f".format(tipAmount)

    //Can also use "Card" instead of "Box"
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        Arrangement.SpaceEvenly
    ) {
        //Can also use "Card" instead of "Box"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp) // Use shadow modifier for elevation
        ) {
            Text(text = "Tip Amount: $$formattedTipAmount", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun TotalMoney(baseAmount: Double, tipPercentage: Double) {
    val tipAmount = baseAmount * tipPercentage
    val totalAmount = baseAmount + tipAmount

    //This creates a limit for decimals shown
    val formattedTotalAmount = "%.2f".format(totalAmount)

    //Can also use "Card" instead of "Box"
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp) // Use shadow modifier for elevation
        ) {
            Text(text = "Total Amount: $$formattedTotalAmount", modifier = Modifier.padding(16.dp))
        }
    }
}