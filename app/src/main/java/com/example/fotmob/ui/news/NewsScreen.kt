package com.example.fotmob.ui.news

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fotmob.ui.NullPage
import com.example.fotmob.ui.theme.BackColor
import com.example.fotmob.ui.theme.MenuColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(){

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val tabItems = listOf<com.example.fotmob.ui.matchs.TabItem>(
        com.example.fotmob.ui.matchs.TabItem("For You"),
        com.example.fotmob.ui.matchs.TabItem("Latest"),
        com.example.fotmob.ui.matchs.TabItem("Transfers"),
        com.example.fotmob.ui.matchs.TabItem("Leagues")
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
                modifier = Modifier.background(BackColor)
            ){

                TopAppBar(
                    title = {
                        Text(
                            text = "News",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    },
                    actions = {
                        Icon(imageVector = Icons.Default.Settings,
                            contentDescription = "")
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = BackColor,
                        scrolledContainerColor = BackColor
                    )
                )

                ScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier
                        .fillMaxWidth(),
                    edgePadding = 0.dp,
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
                .fillMaxWidth()
        ) {index ->
            if (selectedTabIndex == 0){
                ForyouTab(
                    paddingValues
                )
            }else{
                NullPage()
            }
        }

    }
}