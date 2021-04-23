package com.example.weathersimpleapp.models.response

import com.example.weathersimpleapp.models.dto.weather.*
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val base: String,
    @SerializedName("clouds")
    val cloudsDTO: CloudsDTO,
    val cod: Int,
    @SerializedName("coord")
    val coordDTO: CoordDTO,
    val dt: Int,
    val id: Int,
    @SerializedName("main")
    val mainDTO: MainDTO,
    val name: String,
    @SerializedName("sys")
    val sysDTO: SysDTO,
    val timezone: Int,
    val visibility: Int,
    @SerializedName("weather")
    val weatherDTO: List<WeatherDTO>,
    @SerializedName("wind")
    val windDTO: WindDTO
)