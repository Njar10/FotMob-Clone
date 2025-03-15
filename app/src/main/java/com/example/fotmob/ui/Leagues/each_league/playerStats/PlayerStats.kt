package com.example.fotmob.ui.Leagues.each_league.playerStats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fotmob.R

@Composable
fun PlayerStats(){
    val playerStats = listOf(
        "Top scorer",
        "Assists",
        "Goals + Assists",
        "FotMob rating",
        "Goals per 90",
        "Expected goals (xG)",
        "xG per 90",
        "Shots on target",
        "Shots per 90",
        "Accurate passes per 90"
    )
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(playerStats){index ->
            Column (
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.DarkGray)
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = index, modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.messi),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Text(text = "Lionel Messi")
                    }
                    Column (
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Blue),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = "20", color = Color.White,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(horizontal = 5.dp))
                        }
                    }
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.messi),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Text(text = "Lionel Messi")
                    }
                    Column (
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Blue),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = "20", color = Color.White,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(horizontal = 5.dp))
                        }
                    }
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.messi),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Text(text = "Lionel Messi")
                    }
                    Column (
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Blue),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = "20", color = Color.White,
                                fontWeight = FontWeight.Thin,
                                modifier = Modifier.padding(horizontal = 5.dp))
                        }
                    }
                }
            }
        }
    }
}