package com.example.fotmob.ui.matchs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MatchItem(
    color: Color,
    home: String,
    homeIcon: ImageVector,
    score: String,
    away: String,
    awayIcon: ImageVector,
    time: String,

    ){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color)// if match ended will be gray, if is going will be green
        ) {
            Text(
                text = ""//viewModel.matchStatue
             ) //state of match, if ended, 50, tommorow at 11:50

        }

        Row {
            Icon(imageVector = homeIcon, contentDescription = "homeTeamIcon")
            Text("") //match time or score
            Icon(imageVector = homeIcon, contentDescription = "homeTeamIcon")

        }

    }
}