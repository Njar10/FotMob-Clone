package com.example.fotmob.ui.matchs

import android.widget.Space
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.fotmob.ui.theme.BackColor
import com.example.fotmob.ui.theme.MenuColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchesScreen(
    viewModel: MatchesScreenViewModel,
    paddingValues: PaddingValues,
    MatchDetails : () -> Unit
) {
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

    Column (
        Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .nestedScroll(scrollBehavior.nestedScrollConnection)
        ){

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
            scrollBehavior = scrollBehavior,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BackColor,
                scrolledContainerColor = BackColor
            )
        )

        Column (
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                //.background(Color.White)

        ){
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .fillMaxWidth()
                    //.background(Color.White),
                ,edgePadding = 0.dp,
                containerColor = BackColor
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
                        unselectedContentColor = item.unselectedColor,
                        //modifier = Modifier.background(BackColor)
                    )
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {index ->

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                //Text(text = tabItems[index].title)
                FixtureItem(viewModel = MatchesScreenViewModel(),MatchDetails)
                //fixture item here
                //FixtureItem()
                //and the data will be from the view model
            }
        }


    }

}

