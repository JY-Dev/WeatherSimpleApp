package com.example.weathersimpleapp.models.mapping

data class Weather(
    val weather: String,
    val perceptionTemperatureText: String,
    val temperatureText: String,
    val maxTemperatureText : String,
    val minTemperatureText : String,
    val humidityText: String,
    val windSpeedText : String,
    val windGustText : String,
    val weatherIconUrl : String
)