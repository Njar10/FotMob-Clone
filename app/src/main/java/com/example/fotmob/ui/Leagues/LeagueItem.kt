package com.example.fotmob.ui.Leagues

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import com.example.fotmob.data.remote.dto.LeagueData
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.rememberAsyncImagePainter
import com.example.fotmob.ui.theme.BackColor

@Composable
fun LeagueItem(
    league: LeagueData,
    viewModel: LeagueViewModel = viewModel(),
    TeamClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            //.background(BackColor)
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .clickable {
                    expanded = !expanded
                    TeamClicked()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(league.image_path),
                contentDescription = league.name,
                modifier = Modifier.padding(end = 8.dp).size(30.dp)
            )
            Text(
                text = league.name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth()
            )

            /*Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Toggle",
                tint = Color.Red
            )*/
        }

        // Animate visibility of the team list
        /*AnimatedVisibility(
            visible = expanded,
            enter = expandIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300))
        ) {
            Column {
                teams.forEach { team ->
                    Row (
                        modifier = Modifier
                    ){
                        Text(
                            text = team.name,
                            style =  MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .padding(end = 8.dp, bottom = 8.dp)
                        )
                    }
                }
            }
        }*/
    }
}
