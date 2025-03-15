package com.example.fotmob.ui.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.sp
import com.example.fotmob.R
import com.example.fotmob.ui.theme.DarkGreen

@Composable
fun ForyouTab(
    paddingValues: PaddingValues
){

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = paddingValues,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize()
    ) {
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp)

            ){
                Icon(imageVector = Icons.Default.Info,
                    contentDescription = "",
                    Modifier
                        .size(30.dp),
                    tint = DarkGreen)
                Text(text = "Trending", fontWeight = FontWeight.Medium, fontSize = 25.sp)
            }

        }
        item{
            Column (
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .clickable {  }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ){
                Box (
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                ){
                    Image(painter = painterResource(id = R.drawable.news),
                        contentDescription = "")
                }
                Text(text = "Football news : Now is the news title, as u see",
                    fontSize = 20.sp)
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(imageVector = Icons.Default.Info,
                        contentDescription = "",
                        Modifier.size(17.dp))
                    Text(text = "FotMob - 7 hr. ago",
                        fontWeight = FontWeight.Thin, fontSize = 12.sp)
                }
            }
        }
        items(10){
            Row (
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .clickable {  }
                    .height(120.dp)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ){
                Box (
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        //.weight(.33f)
                ){
                    Image(painter = painterResource(id = R.drawable.news),
                        contentDescription = "")
                }
                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight()
                ){
                    Row {
                        Text(text = "Football news : Now is the news title, as u see",
                            fontSize = 15.sp)
                    }
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Default.Info,
                            contentDescription = "",
                            Modifier.size(17.dp),
                            tint = DarkGreen)
                        Text(text = "FotMob - 7 hr. ago",
                            fontWeight = FontWeight.Thin, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}