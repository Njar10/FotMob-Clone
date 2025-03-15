package com.example.fotmob.data.remote.repository

import com.example.fotmob.data.remote.dto.FixturesDto
import com.example.fotmob.data.remote.dto.LeagueResponse
import com.example.fotmob.data.remote.dto.TeamDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class LeagueRepository {

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchLeagues(): LeagueResponse {
        val response = client.get("https://api.sportmonks.com/v3/football/leagues?api_token=4YBrEl8SnLCjm6wgczxGkYlpT6jPHnboJGreOuzo08gdgOEZWofW5DDIWmJu") // Replace with actual API endpoint
        return response.body()
    }

    suspend fun fetchTeams(
        countryId: Int
    ): TeamDto {
        val response = client.get("https://api.sportmonks.com/v3/football/teams/countries/$countryId?api_token=4YBrEl8SnLCjm6wgczxGkYlpT6jPHnboJGreOuzo08gdgOEZWofW5DDIWmJu")
        return response.body()
    }

    suspend fun fetchFixtures(): FixturesDto {
        val response = client.get("https://api.sportmonks.com/v3/football/fixtures?api_token=4YBrEl8SnLCjm6wgczxGkYlpT6jPHnboJGreOuzo08gdgOEZWofW5DDIWmJu")
        return response.body()
    }
}