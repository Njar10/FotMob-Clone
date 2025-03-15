package com.example.fotmob.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TeamDto(
    val data: List<TeamData>
)

@Serializable
data class TeamData(
    val id: Int,
    val sport_id: Int?,
    val venue_id: Int?,
    val gender: String?,
    val name: String,
    val short_code: String?,
    val image_path: String?,
    val founded: Int?,
    val type : String?,
    val country_id: Int?,
    val placeholder: Boolean?,
    val last_played_at: String?
)
