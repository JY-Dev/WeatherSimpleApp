package com.example.weathersimpleapp.data.network.weather

import com.example.weathersimpleapp.BuildConfig
import com.example.weathersimpleapp.models.response.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/data/2.5/weather")
    fun getWeatherFromCityId(@Query("id") cityId : Int,
                             @Query("appid") apiKey : String = BuildConfig.WeatherApiKey) : Single<WeatherResponse>
}