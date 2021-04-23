package com.example.weathersimpleapp.models.dto.city

import android.os.Parcelable
import com.example.weathersimpleapp.models.dto.weather.CoordDTO
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class City(
    val id: Int,
    val name: String,
    val country: String,
    @SerializedName("coord") val coordDTO: CoordDTO
) : Parcelable