package com.example.weathersimpleapp.data.mapper

import com.example.weathersimpleapp.models.mapping.WeatherMapping
import com.example.weathersimpleapp.models.response.WeatherResponse
import com.example.weathersimpleapp.util.fahrenheitToCelsius
import com.example.weathersimpleapp.util.getCelsiusString
import com.example.weathersimpleapp.util.getWeatherIconUrl
import com.example.weathersimpleapp.util.getMeterPerSecondString

class WeatherMapper(private val weatherResponse: WeatherResponse) : BaseMapper<WeatherMapping> {
    override fun getMappingData(): WeatherMapping {
        with(weatherResponse) {
            val weather = weather[0]
            return WeatherMapping(
                weather = weather,
                humidityText = "${main.humidity}%",
                temperatureText = getCelsiusString(fahrenheitToCelsius(main.temperature.toFloat())),
                maxTemperatureText = getCelsiusString(fahrenheitToCelsius(main.maxTemperature.toFloat())),
                minTemperatureText = getCelsiusString(fahrenheitToCelsius(main.minTemperature.toFloat())),
                perceptionTemperatureText = getCelsiusString(fahrenheitToCelsius(main.perceptionTemperature.toFloat())),
                windSpeedText = getMeterPerSecondString(wind.speed.toFloat()),
                windGustText = getMeterPerSecondString(wind.gust.toFloat()),
                weatherIconUrl = getWeatherIconUrl(weather.icon)
            )
        }

    }

}