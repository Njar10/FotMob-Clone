package com.example.fotmob.ui.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fotmob.data.remote.dto.LeagueData
import com.example.fotmob.ui.Leagues.LeagueViewModel
import com.example.fotmob.ui.Leagues.LeaguesScreen
import com.example.fotmob.ui.Leagues.each_league.EachLeagueScreen
import com.example.fotmob.ui.following.FollowingScreen
import com.example.fotmob.ui.matchs.MatchesScreenViewModel
import com.example.fotmob.ui.matchs.MatchesScreen
import com.example.fotmob.ui.matchs.TabItem
import com.example.fotmob.ui.matchs.match_screen.MatchWindow
import com.example.fotmob.ui.more.MoreScreen
import com.example.fotmob.ui.news.NewsScreen
import com.example.fotmob.ui.theme.DarkGreen
import com.example.fotmob.ui.theme.MenuColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    //MatchDetails : () -> Unit,
    //startNews : () -> Unit,
    //startLeagues : () -> Unit,
    //startFollowing : () -> Unit,
    //startMore : () -> Unit
) {
    //Text(text = "Hello $name!")
    val appBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(appBarState)
    var selectedTab by remember {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    val LeagueViewModel: LeagueViewModel = viewModel()
    val MatchsViewModel: MatchesScreenViewModel = viewModel()

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.Black
            ) {
                NavigationBarItem(
                    selected = if (selectedTab == 0) true else{false},
                    onClick = {
                        navController.navigate("matches")
                        selectedTab = 0
                    },
                    icon = {
                        if (selectedTab == 0) {
                            Icon(imageVector = Icons.Filled.Home,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }else {
                            Icon(imageVector = Icons.Outlined.Home,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }

                    },
                    label = {
                        Text(text = "Match")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkGreen, // Color when selected
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = DarkGreen,
                        indicatorColor = Color.Transparent
                    )
                )

                NavigationBarItem(
                    selected = if (selectedTab == 1) true else{false},
                    onClick = {
                        navController.navigate("news")
                        selectedTab = 1
                    },
                    icon = {
                        if (selectedTab == 1) {
                            Icon(imageVector = Icons.Filled.Email,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }else {
                            Icon(imageVector = Icons.Outlined.MailOutline,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }
                    },
                    label = {
                        Text(text = "News")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkGreen, // Color when selected
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = DarkGreen,
                        indicatorColor = Color.Transparent
                    )
                )

                NavigationBarItem(
                    selected = if (selectedTab == 2) true else{false},
                    onClick = {
                        navController.navigate("leagues")
                        selectedTab = 2
                    },
                    icon = {
                        if (selectedTab == 2) {
                            Icon(imageVector = Icons.Filled.Star,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }else {
                            Icon(imageVector = Icons.Outlined.Star,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }
                    },
                    label = {
                        Text(text = "Leagues")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkGreen, // Color when selected
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = DarkGreen,
                        indicatorColor = Color.Transparent
                    )
                )

                NavigationBarItem(
                    selected = if (selectedTab == 3) true else{false},
                    onClick = {
                        navController.navigate("following")
                        selectedTab = 3
                    },
                    icon = {
                        if (selectedTab == 3) {
                            Icon(imageVector = Icons.Filled.Favorite,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }else {
                            Icon(imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }
                    },
                    label = {
                        Text(text = "Following")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkGreen, // Color when selected
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = DarkGreen,
                        indicatorColor = Color.Transparent
                    )
                )

                NavigationBarItem(
                    selected = if (selectedTab == 4) true else{false},
                    onClick = {
                        navController.navigate("more")
                        selectedTab = 4
                    },
                    icon = {
                        if (selectedTab == 4) {
                            Icon(imageVector = Icons.Filled.Menu,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }else {
                            Icon(imageVector = Icons.Outlined.Menu,
                                contentDescription = "",
                                modifier = Modifier.scale(1.2f))
                        }
                    },
                    label = {
                        Text(text = "More")
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = DarkGreen, // Color when selected
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = DarkGreen,
                        indicatorColor = Color.Transparent
                    )
                )
            }

        }
    ){paddingValues ->

        /*val navItems = listOf(
            MatchesScreen(viewModel = MatchesScreenViewModel(),
                paddingValues = paddingValues),
            NewsScreen(),
            LeaguesScreen(viewModel = LeagueViewModel()),
            FollowingScreen(),
            MoreScreen(paddingValues)
        )*/

        //navItems[selectedNavItemIndex]
        NavHost(
            navController = navController,
            startDestination = "matches"
        ){
            composable("matches"){
                MatchesScreen(viewModel = MatchsViewModel,
                    paddingValues = paddingValues,
                    MatchDetails = {
                        navController.navigate("matchDetails")
                    })
            }

            composable("matchDetails"){
                MatchWindow()
            }
            composable("leagues"){
                LeaguesScreen(
                    LeagueViewModel,
                    teamClicked = {
                        navController.navigate("team")
                    }
                )
            }

            composable("team"){
                EachLeagueScreen(
                    viewModel = LeagueViewModel,
                    BackToLeagueScreen = { /*TODO*/ },
                    ToTeamScreen = { /*TODO*/ },
                    startLeagues = { /*TODO*/ },
                    startFollowing = { /*TODO*/ },
                    league = LeagueData(
                        id = 1,
                        sport_id = 123,
                        country_id = 320,
                        name = "Superliga",
                        active = true,
                        short_code = "123",
                        image_path ="https://cdn.sportmonks.com/images/soccer/leagues/271.png",
                        type = "Men",
                        sub_type = "League",
                        last_played_at = "Denmark",
                        category = 0,
                        has_jerseys = true
                    )
                )
            }

            composable("following") {
                FollowingScreen()
            }

            composable("news") {
                NewsScreen()
            }

            composable("more") {
                MoreScreen()
            }
        }

    }

}

/*

package com.example.fotmob.ui.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fotmob.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    startMatch : () -> Unit,
    startNews : () -> Unit,
    startLeagues : () -> Unit,
    startFollowing : () -> Unit,
    startMore : () -> Unit
) {
    //Text(text = "Hello $name!")
    val appBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(appBarState)

    val tabItems = listOf<TabItem>(
        TabItem("Wed 15 Jan"),
        TabItem("Thu 16 Jan"),
        TabItem("Fri 17 Jan"),
        TabItem("Yesterday"),
        TabItem("Today"),
        TabItem("Tomorrow"),
        TabItem("Tue 21 Jan"),
        TabItem("Wed 22 Jan"),
        TabItem("Thu 23 Jan")
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(4)
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
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                TopAppBar(
                    title = { Text(text = "FotMob") },
                    actions = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Icon(imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Ongoing",
                                modifier = Modifier.clickable {  })
                            Icon(imageVector = Icons.Default.DateRange,
                                contentDescription = "Calender",
                                modifier = Modifier.clickable {  })
                            Icon(imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                modifier = Modifier.clickable {  })
                            Icon(imageVector = Icons.Default.MoreVert,
                                contentDescription = "More Options",
                                modifier = Modifier
                                    .clickable { }
                                    .clip(CircleShape))
                        }
                    },
                    scrollBehavior = scrollBehavior
                )

                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier
                        .fillMaxWidth(),
                    edgePadding = 0.dp
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
        },
        bottomBar = {
            BottomAppBar(
                contentPadding = PaddingValues(horizontal = 10.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = "Matches",
                            modifier = Modifier.clickable { startMatch() })
                        Text(text = "Matches", fontWeight = FontWeight.Thin, fontSize = 10.sp)
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.DateRange,
                            contentDescription = "News",
                            modifier = Modifier.clickable {
                                startNews()
                            })
                        Text(text = "News", fontWeight = FontWeight.Thin, fontSize = 10.sp)
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = "Leagues",
                            modifier = Modifier.clickable { startLeagues() })
                        Text(text = "Leagues", fontWeight = FontWeight.Thin, fontSize = 10.sp)
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.Star,
                            contentDescription = "Following",
                            modifier = Modifier.clickable {
                                startFollowing()
                            })
                        Text(text = "Following", fontWeight = FontWeight.Thin, fontSize = 10.sp)
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(imageVector = Icons.Default.Menu,
                            contentDescription = "More",
                            modifier = Modifier.clickable {
                                startMore()
                            })
                        Text(text = "More", fontWeight = FontWeight.Thin, fontSize = 10.sp)
                    }
                }

            }

        }
    ){paddingValues ->


        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {index ->
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
                        //fixture item here
                        FixtureItem()
                        //and the data will be from the view model
                    }
                }

            }
        }


    }

}

/*Row(
modifier = Modifier
.fillMaxWidth()
.background(color = Color.DarkGray)
.padding(10.dp)
.padding(top = 40.dp, bottom = 30.dp)
,
horizontalArrangement = Arrangement.SpaceBetween,
verticalAlignment = Alignment.CenterVertically
) {
    Image(painter = painterResource(id = R.drawable.fotmob),
        "sd",
        modifier = Modifier.background(Color.White))

    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Icon(imageVector = Icons.Default.CheckCircle,
            contentDescription = "Ongoing")
        Icon(imageVector = Icons.Default.DateRange,
            contentDescription = "Calender")
        Icon(imageVector = Icons.Default.Search,
            contentDescription = "Search")
        Icon(imageVector = Icons.Default.MoreVert,
            contentDescription = "More Options")
    }
}*/

*/