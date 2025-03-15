package com.example.fotmob.ui.matchs.match_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fotmob.R
import com.example.fotmob.ui.NullPage
import com.example.fotmob.ui.matchs.TabItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchWindow(){
    val appBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(appBarState)

    val tabItems = listOf<TabItem>(
        TabItem("Preview"),
        TabItem("Lineup"),
        TabItem("Table"),
        TabItem("H2H")
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
            Column {
                TopAppBar(
                    navigationIcon = {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "")
                    },
                    title = {

                    },
                    actions = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Notifications,
                                contentDescription = "")
                            Icon(imageVector = Icons.Outlined.Star,
                                contentDescription = "")
                            Icon(imageVector = Icons.Default.MoreVert,
                                contentDescription = "")
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
                //Spacer(modifier = Modifier.padding(10.dp))

                Column (
                    Modifier.padding(bottom = 10.dp)
                ){
                    Row (
                        Modifier
                            .fillMaxWidth()
                    ){
                        Column (
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.levr),
                                contentDescription = "")
                            Text(text = "Liverpool")
                        }
                        Column (
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(text = "7:00 PM", style = MaterialTheme.typography.headlineLarge)
                            Text(text = "04:48:02", style = MaterialTheme.typography.titleSmall)
                        }
                        Column (
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.levr),
                                contentDescription = "")
                            Text(text = "Liverpool")
                        }

                    }
                    //Spacer(modifier = Modifier.padding(10.dp))
                }
                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    /*modifier = Modifier
                        .fillMaxWidth(),*/
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
        }
    ) {paddingValues ->

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            paddingValues
        ) {index ->
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                //Text(text = tabItems[index].title)
                if (selectedTabIndex == 0){
                    PreviewScr()
                } else{
                    NullPage()
                }
                //fixture item here
                //FixtureItem()
                //and the data will be from the view model
            }
        }

    }
}