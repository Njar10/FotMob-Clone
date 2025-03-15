package com.example.fotmob.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LeagueDto(
    val id: Int,
    val name: String,
    val image_path: String
)
