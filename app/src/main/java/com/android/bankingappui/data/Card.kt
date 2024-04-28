package com.android.bankingappui.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class Card(
    val cardType : String,
    val cardNumber : String,
    val cardName : String,
    val balance : Double,
    val color : Brush
)

