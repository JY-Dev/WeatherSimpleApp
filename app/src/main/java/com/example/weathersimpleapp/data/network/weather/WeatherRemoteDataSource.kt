package com.example.weathersimpleapp.data.network.weather

import com.example.weathersimpleapp.models.response.WeatherResponse
import io.reactivex.rxjava3.core.Single

interface WeatherRemoteDataSource {
    fun getWeatherFromCityId(cityId : Int) : Single<WeatherResponse>
}