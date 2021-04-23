package com.example.weathersimpleapp.data.mapper

import com.example.weathersimpleapp.models.mapping.WeatherMapping
import com.example.weathersimpleapp.models.response.WeatherResponse
import com.example.weathersimpleapp.util.*

class WeatherMapper(private val weatherResponse: WeatherResponse) : BaseMapper<WeatherMapping> {
    override fun getMappingData(): WeatherMapping {
        with(weatherResponse) {
            val weather = weather[0]
            return WeatherMapping(
                weather = weather,
                humidityText = "${main.humidity}%",
                temperatureText = getCelsiusString(kelvinToCelsius(main.temperature.toFloat())),
                maxTemperatureText = getCelsiusString(kelvinToCelsius(main.maxTemperature.toFloat())),
                minTemperatureText = getCelsiusString(kelvinToCelsius(main.minTemperature.toFloat())),
                perceptionTemperatureText = getCelsiusString(kelvinToCelsius(main.perceptionTemperature.toFloat())),
                windSpeedText = getMeterPerSecondString(wind.speed.toFloat()),
                windGustText = getMeterPerSecondString(wind.gust.toFloat()),
                weatherIconUrl = getWeatherIconUrl(weather.icon)
            )
        }

    }

}