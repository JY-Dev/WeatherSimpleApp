package com.example.weathersimpleapp.models.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * lat : 위도
 * lon : 경도
 */
@Parcelize
data class Coord(
    val lat: Double,
    val lon: Double
) : Parcelable