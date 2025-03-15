package com.example.fotmob.ui.matchs

import androidx.compose.ui.graphics.Color

data class TabItem(
    val title : String,
    val selectedColor : Color = Color.White,
    val unselectedColor : Color = Color.LightGray,
)
