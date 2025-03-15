package com.example.fotmob.ui.matchs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fotmob.data.remote.dto.FixtureData
import com.example.fotmob.data.remote.repository.LeagueRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MatchesScreenViewModel (
): ViewModel(){

    private val repository: LeagueRepository = LeagueRepository()
    val fixtures = MutableStateFlow<List<FixtureData>>(emptyList())

    init {
        fetchFixtures()
    }

    fun fetchFixtures(){
        viewModelScope.launch {
            try {
                val response = repository.fetchFixtures()
                fixtures.value = response.data
            } catch (e: Exception){
                println("fixturess: Error fetching fixtures: ${e.message}")
            }
        }
    }
}