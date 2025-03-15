package com.example.fotmob.ui.Leagues.each_league.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fotmob.R
import com.example.fotmob.ui.Leagues.LeagueViewModel

@Composable
fun News(
    LeaguesViewModel: LeagueViewModel = viewModel()
){
    val news = LeaguesViewModel.news.collectAsState()
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ){
        items(5){
            Card (
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .height(400.dp)
                    .background(Color.LightGray)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Box(
                        modifier = Modifier
                            .weight(8f)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.news),
                            contentDescription = ""
                        )
                    }
                    Text(
                        text = "Here will be a news title..",
                        fontWeight = FontWeight.Medium,
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier.weight(1f).padding(horizontal = 10.dp)
                    )
                    Row (
                        modifier = Modifier.weight(1f).padding(horizontal = 10.dp)
                    ){
                        Text(
                            text = "Here will be a news description..",
                            fontWeight = FontWeight.Thin,
                            fontSize = 10.sp,
                            color = Color.White
                        )
                        Text(
                            text = "1 hr. ago",
                            fontWeight = FontWeight.Thin,
                            fontSize = 10.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}