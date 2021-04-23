package com.example.weathersimpleapp.models.dto.weather

import com.google.gson.annotations.SerializedName

/**
 * type : Internal param
 * id : Internal type
 * sunriseTime : 일출 시간
 * sunsetTime : 일몰 시간
 */
data class SysDTO(
    @SerializedName("country")
    val countryCode : String,
    val id: Int,
    @SerializedName("sunrise")
    val sunriseTime: Int,
    @SerializedName("sunset")
    val sunsetTime: Int,
    val type: Int
)