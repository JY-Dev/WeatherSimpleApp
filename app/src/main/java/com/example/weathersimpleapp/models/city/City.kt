package com.example.weathersimpleapp.models.city

import android.os.Parcelable
import com.example.weathersimpleapp.models.weather.Coord
import kotlinx.android.parcel.Parcelize


@Parcelize
data class City(val id: Int, val name: String, val country : String , val coord: Coord) : Parcelable