package com.example.cocotipper.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cocotipper.model.CocoTipperModel

class CocoTipperViewModel : ViewModel() {
    val cocoTipperModel = mutableStateOf(CocoTipperModel())
    private val defaultModel = CocoTipperModel()

    fun onBaseAmountChange(amount: String) {
        cocoTipperModel.value = cocoTipperModel.value.copy(baseAmount = amount)
    }

    fun onTipPercentageChange(percentage: Double) {
        cocoTipperModel.value = cocoTipperModel.value.copy(tipPercentage = percentage)
    }

    fun resetValuesToDefault() {
        cocoTipperModel.value = defaultModel
    }
}
