package com.example.weathersimpleapp.models.city

import com.example.weathersimpleapp.models.weather.Coord


data class City(val id: Int, val name: String, val country : String , val coord: Coord)