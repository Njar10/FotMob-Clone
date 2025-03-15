package com.example.fotmob.ui.matchs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MSItems(
    league: String,
    date: String,
    time: String,
    home: String,
    score: String,
    away: String,
    icon: ImageVector
){
    Column(
        Modifier.fillMaxWidth()
    ) {
        Icon(imageVector = icon, contentDescription = "league icon")
        Text(text = league)
        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "arrow")
    }
    /*LazyColumn(
        Modifier.fillMaxWidth()
    ) {
        items(){

        }
    }*/
}