package com.example.weathersimpleapp.data.repository

import com.example.weathersimpleapp.data.network.weather.WeatherRemoteDataSource
import com.example.weathersimpleapp.models.response.WeatherResponse
import io.reactivex.rxjava3.core.Single

class WeatherRepositoryImpl(private val weatherRemoteDataSource : WeatherRemoteDataSource) : WeatherRepository {

    override fun getWeatherFromCityId(cityId : Int) : Single<WeatherResponse> =
        weatherRemoteDataSource.getWeatherFromCityId(cityId)

}