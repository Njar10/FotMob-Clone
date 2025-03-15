package com.example.fotmob.ui.Leagues.each_league.table

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fotmob.ui.Leagues.LeagueViewModel
import com.example.fotmob.ui.theme.BackColor
import com.example.fotmob.ui.theme.GrayColor

@Composable
fun TablePage(
    //league : LeagueData
    viewModel: LeagueViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    val teams by viewModel.teams.collectAsState()

    Column {
        LazyColumn (
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize()
                .background(BackColor)
        ){

            item{
                Row (
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Box (
                        Modifier.weight(.45f)
                    ){
                        Row (
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            Text(text = "#")
                            Text(text = "Team")
                        }
                    }

                    Box (
                        Modifier.weight(.55f),
                        contentAlignment = Alignment.CenterEnd
                    ){
                        Row (
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            Text(text = "Pl",Modifier.weight(1f),fontSize = 13.sp)
                            Text(text = "W",Modifier.weight(1f),fontSize = 13.sp)
                            Text(text = "D",Modifier.weight(1f),fontSize = 13.sp)
                            Text(text = "L",Modifier.weight(1f),fontSize = 13.sp)
                            Text(text = "+/-",Modifier.weight(2f),fontSize = 13.sp)
                            Text(text = "GD",Modifier.weight(1f),fontSize = 13.sp)
                            Text(text = "Pts",Modifier.weight(1f),fontSize = 13.sp)
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    color = GrayColor
                )
            }
            items(20){
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .clickable { },
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Box (
                        Modifier.weight(.45f),
                        contentAlignment = Alignment.TopStart
                    ){
                        Row {
                            Text(text = "team name")
                        }
                    }

                    Box (
                        Modifier.weight(.55f),
                        contentAlignment = Alignment.CenterEnd
                    ){
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            Box(
                                Modifier.weight(1f)
                            ) {
                                Text(text = "23", fontWeight = FontWeight.W200)
                            }
                            Box(
                                Modifier.weight(1f)
                            ) {
                                Text(text = "17", fontWeight = FontWeight.W200)
                            }
                            Box(
                                Modifier.weight(1f)
                            ) {
                                Text(text = "33", fontWeight = FontWeight.W200)
                            }
                            Box(
                                Modifier.weight(1f)
                            ) {
                                Text(text = "33", fontWeight = FontWeight.W200)
                            }
                            Box(
                                Modifier.weight(2f)
                            ) {
                                Text(text = "38-10", fontWeight = FontWeight.W200)
                            }
                            Box(
                                Modifier.weight(1f)
                            ) {
                                Text(text = "+22", fontWeight = FontWeight.W200)
                            }
                            Box(
                                Modifier.weight(1f)
                            ) {
                                Text(text = "54", fontWeight = FontWeight.W200)
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }

}