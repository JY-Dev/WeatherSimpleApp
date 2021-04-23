package com.example.weathersimpleapp.models.dto.weather

import com.google.gson.annotations.SerializedName

/**
 * speed : 풍속
 * direction : 풍향
 * gust : 돌풍
 */
data class WindDTO(
    @SerializedName("deg")
    val direction: Int,
    val gust: Double,
    val speed: Double
)