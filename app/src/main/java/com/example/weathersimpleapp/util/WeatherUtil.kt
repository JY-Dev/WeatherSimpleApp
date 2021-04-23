package com.example.weathersimpleapp.util

fun getWeatherIconUrl(iconId : String) : String =
    "http://openweathermap.org/img/wn/${iconId}.png"

fun getCelsiusString(celsius : Float) : String =
    "$celsius℃"

fun fahrenheitToCelsius(fahrenheit : Float) : Float =
    (fahrenheit-32)/1.8.toFloat()

fun getMeterPerSecondString(value : Float) : String =
    "${value}m/s"