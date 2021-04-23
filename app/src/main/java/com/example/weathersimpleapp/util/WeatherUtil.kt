package com.example.weathersimpleapp.util

fun getWeatherIconUrl(iconId : String) : String =
    "http://openweathermap.org/img/wn/${iconId}@2x.png"

fun getCelsiusString(celsius : Int) : String =
    "$celsius℃"

fun kelvinToCelsius(kelvin : Float) : Int =
    (kelvin-273).toInt()

fun getMeterPerSecondString(value : Float) : String =
    "${value}m/s"