package com.example.weathersimpleapp.data.mapper

import com.example.weathersimpleapp.models.mapping.Weather
import com.example.weathersimpleapp.models.response.WeatherResponse
import com.example.weathersimpleapp.util.*

class WeatherMapper(private val weatherResponse: WeatherResponse) : BaseMapper<Weather> {
    override fun getMappingData(): Weather {
        with(weatherResponse) {
            val weather = weatherDTO[0]
            return Weather(
                weather = weather.param,
                humidityText = "${mainDTO.humidity}%",
                temperatureText = getCelsiusString(kelvinToCelsius(mainDTO.temperature.toFloat())),
                maxTemperatureText = getCelsiusString(kelvinToCelsius(mainDTO.maxTemperature.toFloat())),
                minTemperatureText = getCelsiusString(kelvinToCelsius(mainDTO.minTemperature.toFloat())),
                perceptionTemperatureText = getCelsiusString(kelvinToCelsius(mainDTO.perceptionTemperature.toFloat())),
                windSpeedText = getMeterPerSecondString(windDTO.speed.toFloat()),
                windGustText = getMeterPerSecondString(windDTO.gust.toFloat()),
                weatherIconUrl = getWeatherIconUrl(weather.icon)
            )
        }

    }

}