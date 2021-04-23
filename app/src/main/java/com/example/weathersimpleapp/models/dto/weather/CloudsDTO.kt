package com.example.weathersimpleapp.models.dto.weather

import com.google.gson.annotations.SerializedName

/**
 * cloudiness : 날씨 흐린정도
 */
data class CloudsDTO(
    @SerializedName("all")
    val cloudiness: Int
)