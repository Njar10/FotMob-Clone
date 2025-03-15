package com.example.fotmob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fotmob.data.remote.dto.LeagueData
import com.example.fotmob.ui.Leagues.LeagueViewModel
import com.example.fotmob.ui.Leagues.LeaguesScreen
import com.example.fotmob.ui.Leagues.each_league.EachLeagueScreen
import com.example.fotmob.ui.following.FollowingScreen
import com.example.fotmob.ui.main_screen.MainScreen
import com.example.fotmob.ui.matchs.MatchesScreenViewModel
import com.example.fotmob.ui.more.MoreScreen
import com.example.fotmob.ui.news.NewsScreen
import com.example.fotmob.ui.theme.FotMobTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val LeagueViewModel: LeagueViewModel = viewModel()
            val MatchsViewModel: MatchesScreenViewModel = viewModel()
            val navController = rememberNavController()
            FotMobTheme {
                MainScreen()
            }
        }
    }
}
