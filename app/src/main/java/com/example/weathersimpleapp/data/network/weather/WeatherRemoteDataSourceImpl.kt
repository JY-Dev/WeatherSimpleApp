package com.example.weathersimpleapp.data.network.weather

import com.example.weathersimpleapp.data.network.BaseRemoteDataSource
import com.example.weathersimpleapp.models.response.WeatherResponse
import io.reactivex.rxjava3.core.Single

class WeatherRemoteDataSourceImpl(private val weatherService : WeatherService) : WeatherRemoteDataSource, BaseRemoteDataSource() {
    override fun getWeatherFromCityId(cityId : Int) : Single<WeatherResponse> =
        weatherService.getWeatherFromCityId(cityId).setNetworkThread()
}