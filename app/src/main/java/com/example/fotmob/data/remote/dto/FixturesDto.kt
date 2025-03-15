package com.example.fotmob.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class FixturesDto(
    val data: List<FixtureData>
)

@Serializable
data class FixtureData(
    val id: Int?,
    val sport_id: Int?,
    val league_id: Int?,
    val season_id: Int?,
    val stage_id: Int?,
    val group_id: Int?,
    val aggregate_id: Int?,
    val round_id: Int?,
    val state_id: Int?,
    val venue_id: Int?,
    val name: String,
    val starting_at: String?,
    val result_info: String?,
    val leg: String?,
    val details: String?,
    val length : Int?,
    val placeholder : Boolean?,
    val has_premium_odds : Boolean?,
    val has_odds : Boolean?,
    val starting_at_timestamp : Int?,
)
