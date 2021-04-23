package com.example.weathersimpleapp.data.repository

import com.example.weathersimpleapp.models.response.WeatherResponse
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {
    fun getWeatherFromCityId(cityId : Int) : Single<WeatherResponse>
}