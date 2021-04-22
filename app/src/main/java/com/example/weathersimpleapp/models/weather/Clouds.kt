package com.example.weathersimpleapp.models.weather

import com.google.gson.annotations.SerializedName

/**
 * cloudiness : 날씨 흐린정도
 */
data class Clouds(
    @SerializedName("all")
    val cloudiness: Int
)