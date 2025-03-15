package com.example.fotmob.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class LeagueResponse(
    val data: List<LeagueData>,
    val pagination: Pagination?,
    val subscription: List<Subscription> = emptyList(), // Ignore subscription field
    val rate_limit: RateLimit,
    val timezone: String
)

@Serializable
data class LeagueData(
    val id: Int,
    val sport_id: Int,
    val country_id: Int,
    val name: String,
    val active: Boolean,
    val short_code: String?,
    val image_path: String,
    val type: String,
    val sub_type: String,
    val last_played_at: String,
    val category: Int,
    val has_jerseys: Boolean
)

@Serializable
data class Pagination(
    val count: Int,
    val per_page: Int,
    val current_page: Int,
    val next_page: Int?,
    val has_more : Boolean?
)

@Serializable
data class Subscription(
    val meta: List<String>,
    val plans: List<Plan>,
    val add_ons: List<String>,
    val widgets: List<String>
)

@Serializable
data class Plan(
    val plan: String,
    val sport: String,
    val category: String
)

@Serializable
data class RateLimit(
    val resets_in_seconds: Int,
    val remaining: Int,
    val requested_entity: String
)