package com.example.cocotipper.subscreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun TipResult(baseAmount: Double, tipPercentage: Double) {
    val tipAmount = baseAmount * tipPercentage
    val totalAmount = baseAmount + tipAmount

    //This creates a limit for decimals shown
    val formattedTipAmount = "%.2f".format(tipAmount)
    val formattedTotalAmount = "%.2f".format(totalAmount)

    //Can also use "Card" instead of "Box"
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        //Can also use "Card" instead of "Box"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .shadow(elevation = 2.dp) // Use shadow modifier for elevation
        ) {
            Text(text = "Tip Amount: $$formattedTipAmount", modifier = Modifier.padding(16.dp))
        }
        //Can also use "Card" instead of "Box"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 75.dp) // Offset the second box to avoid overlap
                .shadow(elevation = 2.dp) // Use shadow modifier for elevation
        ) {
            Text(text = "Total Amount: $$formattedTotalAmount", modifier = Modifier.padding(16.dp))
        }
    }
}