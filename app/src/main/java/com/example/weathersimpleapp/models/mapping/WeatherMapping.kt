package com.example.weathersimpleapp.models.mapping

import com.example.weathersimpleapp.models.weather.Weather

data class WeatherMapping(
    val weather: Weather,
    val perceptionTemperatureText: String,
    val temperatureText: String,
    val maxTemperatureText : String,
    val minTemperatureText : String,
    val humidityText: String,
    val windSpeedText : String,
    val windGustText : String,
    val weatherIconUrl : String
)