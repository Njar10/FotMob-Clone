package com.example.fotmob.ui.matchs

import android.widget.ExpandableListView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.example.fotmob.R
import com.example.fotmob.data.remote.dto.LeagueData
import com.example.fotmob.ui.Leagues.LeagueViewModel
import com.example.fotmob.ui.theme.BackColor
import com.example.fotmob.ui.theme.GrayTextColor

@Composable
fun FixtureItem(
    viewModel: MatchesScreenViewModel = viewModel(),
    //FixtureClicked: () -> Unit
    MatchDetails : () -> Unit
) {
    var expanded by remember { mutableStateOf(true) }
    val fixtures by viewModel.fixtures.collectAsState()
    val matches by remember {
        mutableStateOf(listOf(20))
    }
    LazyColumn (
        Modifier.background(BackColor).padding(horizontal = 8.dp)
    ){

        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(20){

            Column (
                modifier = Modifier
                    .clickable {
                        MatchDetails()
                    }
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Liverpool",
                        style =  MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.levr),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                    )
                    /*Text(
                        text = fixture.name,
                        style =  MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )*/

                    Text(
                        text = "7:45 PM",
                        style =  MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        color = GrayTextColor
                    )

                    Image(
                        painter = painterResource(id = R.drawable.levr),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                    )

                    Text(
                        text = "Liverpool",
                        style =  MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                }
                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(imageVector = Icons.Default.Info,
                        contentDescription = "",
                        Modifier.scale(.5f),
                        tint = Color.Gray)
                    Icon(imageVector = Icons.Default.LocationOn,
                        contentDescription = "",
                        Modifier.scale(.5f),
                        tint = Color.Gray)
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "",
                        Modifier.scale(.5f),
                        tint = Color.Gray)
                }
            }

            /*Column(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 2.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(BackColor),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable {
                            expanded = !expanded
                            viewModel.fetchFixtures()
                            //FixtureClicked()
                        }
                        .padding(vertical = 8.dp, horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = "Matches",
                            style = MaterialTheme.typography.headlineSmall,
                            //modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Toggle",
                        tint = Color.White
                    )
                }

                // Animate visibility of the team list
                AnimatedVisibility(
                    visible = expanded,
                    enter = expandIn(animationSpec = tween(300)),
                    exit = fadeOut(animationSpec = tween(300))
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize(),
                        //verticalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        HorizontalDivider(
                            color = Color.Black
                        )

                        fixtures.forEach { fixture ->
                            Column (
                                modifier = Modifier
                                    .clickable {
                                        MatchDetails()
                                    }
                            ){
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = "Liverpool",
                                        style =  MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.levr),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                    /*Text(
                                        text = fixture.name,
                                        style =  MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                    )*/

                                    Text(
                                        text = "7:45 PM",
                                        style =  MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                    )

                                    Image(
                                        painter = painterResource(id = R.drawable.levr),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(30.dp)
                                    )

                                    Text(
                                        text = "Liverpool",
                                        style =  MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                    )
                                }
                                Row (
                                ){
                                    Icon(imageVector = Icons.Default.Info,
                                        contentDescription = "")
                                }
                            }
                        }
                        /*Row (
                            modifier = Modifier
                                .height(100.dp)
                                .background(Color.Red)
                        ){
                            Text(
                                text = "sdadasdas",
                                style =  MaterialTheme.typography.headlineMedium,
                                modifier = Modifier
                                    .padding(end = 8.dp, bottom = 8.dp)
                            )
                        }*/
                    }
                }
            }*/
        }

    }

}

/*

"data": [
        {
            "id": 216268,
            "sport_id": 1,
            "league_id": 271,
            "season_id": 1273,
            "stage_id": 1086,
            "group_id": null,
            "aggregate_id": null,
            "round_id": 23332,
            "state_id": 5,
            "venue_id": 618,
            "name": "Esbjerg vs OB",
            "starting_at": "2006-03-25 16:00:00",
            "result_info": "Esbjerg won after full-time.",
            "leg": "1/1",
            "details": null,
            "length": 90,
            "placeholder": false,
            "has_odds": false,
            "has_premium_odds": false,
            "starting_at_timestamp": 1143302400
        },

 */
