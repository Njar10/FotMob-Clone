package com.example.fotmob.ui.more

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fotmob.ui.theme.BackColor
import com.example.fotmob.ui.theme.MenuColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(){
    Scaffold {
        Column {
            TopAppBar(
                title = {
                    Text(text = "More", fontWeight = FontWeight.Medium)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackColor,
                    scrolledContainerColor = BackColor
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                    Text(text = "Sign in to sync settings across devices or retrieve them when you set up a new device")
                }
                Row (
                    modifier = Modifier.padding(horizontal=20.dp)
                ){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Sign in")
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                ){
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    Column {
                        Text(text = "FotMob+")
                        Text(text = "Remove ads and get exclusive benefits")
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                ){
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
                    Text(text = "Transfer Center")
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                ){
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "")
                    Column {
                        Text(text = "TV schedules")
                        Text(text = "Middle East")
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                ){
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
                    Column {
                        Text(text = "Notifications")
                        Text(text = "You have disabled Notification For FotMob")
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                ){
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                    Text(text = "Settings")
                }


            }
        }
    }

}
