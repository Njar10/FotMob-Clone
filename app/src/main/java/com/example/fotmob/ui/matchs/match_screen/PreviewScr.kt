package com.example.fotmob.ui.matchs.match_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fotmob.R
import com.example.fotmob.ui.theme.BackColor
import com.example.fotmob.ui.theme.DarkGreen
import com.example.fotmob.ui.theme.GrayColor
import com.example.fotmob.ui.theme.GrayTextColor

@Composable
fun PreviewScr(){

    var totalVotes = 860 // in real life program u will get this from app server.

    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 10.dp)
    ){

        item(){
            Spacer(modifier = Modifier.size(20.dp))
            Column(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(BackColor)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ){
                    Text(text = "Who will win?")
                    Text(text = "Total votes: $totalVotes", color = GrayTextColor)
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(3.dp))
                            .border(1.dp, color = GrayColor, shape = RoundedCornerShape(3f))
                            .height(30.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.levr),
                            contentDescription = "",
                            modifier = Modifier.scale(.7f))
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(3.dp))
                            .border(1.dp, color = GrayColor, shape = RoundedCornerShape(3f))
                            .height(30.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "Draw")
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(3.dp))
                            .border(1.dp, color = GrayColor, shape = RoundedCornerShape(3f))
                            .height(30.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Image(painter = painterResource(id = R.drawable.levr),
                            contentDescription = "",
                            modifier = Modifier.scale(.7f))
                    }
                }

            }
        }

        item {
            Column (
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(BackColor)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ){
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.clickable {  }
                ) {
                    Icon(imageVector = Icons.Default.DateRange,
                        contentDescription = "")

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(BackColor)
                    ){
                        Text(text = "Fri, Feb 28, 2025, 7:00 PM")
                    }
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.clickable {  }
                ) {
                    Icon(imageVector = Icons.Default.DateRange,
                        contentDescription = "")

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(BackColor)
                    ){
                        Text(text = "Premier League - Round 16")
                    }
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.clickable {  }
                ) {
                    Icon(imageVector = Icons.Default.DateRange,
                        contentDescription = "")

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(BackColor)
                    ){
                        Text(text = "Alexandria Stadium, Alexandria")
                    }
                }

                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.clickable {  }
                ){
                    Icon(imageVector = Icons.Default.DateRange,
                        contentDescription = "")

                    Row {
                        Text(text = "Ahmed Njar")
                    }
                }
            }
        }

        item {
            Column (
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(BackColor)
            ){
                Row (
                    Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                ){
                    Text(text = "Team form")
                }

                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column (
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ){
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Column (
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ){
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                        TeamFormItem(true,"3 - 2")
                    }
                }
            }
        }

    }
}

@Composable
fun TeamFormItem(
    hasWon : Boolean,
    result: String
){

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { }
    ){
        Image(painter = painterResource(id = R.drawable.levr),
            contentDescription = "", modifier = Modifier.weight(1f).scale(.8f))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (hasWon) {
                        DarkGreen
                    } else {
                        Color.Red
                    }
                )
                .weight(1f),
            contentAlignment = Alignment.Center
        ){
            Text(text = result)
        }

        Image(painter = painterResource(id = R.drawable.levr),
            contentDescription = "", modifier = Modifier.weight(1f).scale(.8f))

    }
}