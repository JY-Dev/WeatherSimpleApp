package com.example.weathersimpleapp.models.dto.weather

import com.google.gson.annotations.SerializedName

/**
 * feels_like : 체감온도
 * humidity : 습도
 * pressure : 대기압
 */
data class MainDTO(
    @SerializedName("feels_like")
    val perceptionTemperature: Double,
    val humidity: Int,
    val pressure: Int,
    @SerializedName("temp")
    val temperature: Double,
    @SerializedName("temp_max")
    val maxTemperature: Double,
    @SerializedName("temp_min")
    val minTemperature: Double
)