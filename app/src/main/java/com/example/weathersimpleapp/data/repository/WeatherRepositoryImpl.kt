package com.example.weathersimpleapp.data.repository

import com.example.weathersimpleapp.data.mapper.WeatherMapper
import com.example.weathersimpleapp.data.network.weather.WeatherRemoteDataSource
import com.example.weathersimpleapp.models.mapping.Weather
import io.reactivex.rxjava3.core.Single

class WeatherRepositoryImpl(private val weatherRemoteDataSource : WeatherRemoteDataSource) : WeatherRepository {

    override fun getWeatherFromCityId(cityId : Int) : Single<Weather> =
        weatherRemoteDataSource.getWeatherFromCityId(cityId).map {
            WeatherMapper(it).getMappingData()
        }

}