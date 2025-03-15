package com.example.fotmob.ui.Leagues

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fotmob.data.remote.dto.LeagueData
import com.example.fotmob.data.remote.dto.TeamData
import com.example.fotmob.data.remote.dto.TeamDto
import com.example.fotmob.data.remote.repository.LeagueRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

class LeagueViewModel() : ViewModel() {

    private val repository = LeagueRepository()
    private val _leagues = MutableStateFlow<List<LeagueData>>(emptyList())
    val leagues: StateFlow<List<LeagueData>> = _leagues

    val news = MutableStateFlow<List<String>>(emptyList())

    val teams = MutableStateFlow<List<TeamData>>(emptyList())

    init {
        fetchLeagues()
    }

    private fun fetchLeagues() {
        viewModelScope.launch {
            try {
                val response = repository.fetchLeagues()
                _leagues.value = response.data

            } catch (e: Exception) {
                println("ahmed: Error fetching leagues: ${e.message}")
            }
        }
    }
    fun fetchTeams(
        countryId: Int
    ) {
        /*viewModelScope.launch {
            try {
                val response = repository.fetchTeams(countryId)
                teams.value = response.data
            }catch (e: Exception){
                println("asd: Error fetching teams: ${e.message}")
            }
        }*/
    }

}