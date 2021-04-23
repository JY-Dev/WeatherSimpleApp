package com.example.weathersimpleapp.models.dto.weather

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * lat : 위도
 * lon : 경도
 */
@Parcelize
data class CoordDTO(
    val lat: Double,
    val lon: Double
) : Parcelable