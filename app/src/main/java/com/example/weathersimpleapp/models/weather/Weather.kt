package com.example.weathersimpleapp.models.weather

import com.google.gson.annotations.SerializedName

/**
 *  description : 기상상태
 *  main : Weather Param (Rain , Snow , Extreme etc)
 *  id : 기상상태 id
 *  icon : weather icon id
 */
data class Weather(
    @SerializedName("description")
    val status: String,
    val icon: String,
    @SerializedName("id")
    val statusId: Int,
    @SerializedName("main")
    val param: String
)