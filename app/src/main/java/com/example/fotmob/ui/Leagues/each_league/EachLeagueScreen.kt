package com.example.fotmob.ui.Leagues.each_league

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.example.fotmob.data.remote.dto.LeagueData
import com.example.fotmob.ui.Leagues.LeagueViewModel
import com.example.fotmob.ui.Leagues.each_league.news.News
import com.example.fotmob.ui.Leagues.each_league.playerStats.PlayerStats
import com.example.fotmob.ui.Leagues.each_league.table.TablePage
import com.example.fotmob.ui.Leagues.playerStats.TeamStats
import com.example.fotmob.ui.matchs.TabItem
import com.example.fotmob.ui.theme.MenuColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EachLeagueScreen(
    viewModel: LeagueViewModel,
    BackToLeagueScreen : () -> Unit,
    ToTeamScreen : () -> Unit,
    startLeagues : () -> Unit,
    startFollowing : () -> Unit,
    league: LeagueData
){

    val leagueTeams = viewModel.teams.collectAsState()
    val appBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val leagueData = league
    viewModel.fetchTeams(league.country_id)

    val tabItems = listOf<TabItem>(
        TabItem("Table"),
        TabItem("Fixtures"),
        TabItem("News"),
        TabItem("Player stats"),
        TabItem("Team stats"),
        TabItem("Transfers"),
        TabItem("TOTW"),
        TabItem("Seasons")
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress){
            selectedTabIndex = pagerState.currentPage
        }
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.background(MenuColor)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f)
                    ){
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .clickable {

                                }
                        ){
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "",
                                tint = Color.White
                            )
                        }

                        Column (
                            Modifier.padding(horizontal = 10.dp)
                        ){
                            Box {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ){
                                    Text(text = "2024/2025",color = Color.White)
                                    Icon(
                                        imageVector = Icons.Default.ArrowDropDown,
                                        contentDescription = "",
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .size(20.dp),
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.weight(1f)
                    ){
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "",
                            modifier = Modifier
                                .clickable {

                                }
                                .clip(CircleShape),
                            tint = Color.White
                        )
                        Column (
                            Modifier.padding(start = 10.dp)
                        ){
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Following",
                                    color = Color.Black,
                                    modifier = Modifier.padding(horizontal = 10.dp),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }

                }

                TopAppBar(
                    title = {
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .background(MenuColor)
                                //.fillMaxWidth()
                        ){
                            Box(
                                modifier = Modifier
                                    //.background(Color.White)
                                    .clip(RoundedCornerShape(5.dp)),
                                contentAlignment = Alignment.Center
                            ){
                                Image(
                                    painter = rememberAsyncImagePainter(league.image_path),
                                    contentDescription = leagueData.name,
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .size(50.dp)
                                )
                            }

                            Column (
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                                //, modifier = Modifier.background(MenuColor)
                            ){
                                Text(
                                    text = leagueData.name,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    text = leagueData.last_played_at,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                            }
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MenuColor
                    )
                )

                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MenuColor),
                    edgePadding = 0.dp,
                    containerColor = MenuColor
                ) {
                    tabItems.forEachIndexed { index, item ->
                        Tab(
                            selected = index == selectedTabIndex,
                            onClick = {
                                selectedTabIndex = index
                            },
                            text = {
                                Text(text = item.title)
                            },
                            selectedContentColor = item.selectedColor,
                            unselectedContentColor = item.unselectedColor
                        )
                    }
                }


            }
        }
    ){paddingValues ->

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            paddingValues
        ) {index ->
            //val tab = tabItems[index]
            Column (
                Modifier.fillMaxSize()
            ){
                if(index == 0){
                    TablePage()
                }else if(index == 3){
                    PlayerStats()
                }else if(index == 4){
                    TeamStats()
                }else{
                    News()
                }
                //Column(modifier = Modifier.height(30.dp)){}
            }
        }
    }
}


/*

LazyColumn {
                items(20){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = tabItems[index].title)
                    }
                }

            }
 */