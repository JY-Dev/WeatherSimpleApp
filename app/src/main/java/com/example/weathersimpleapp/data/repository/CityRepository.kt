package com.example.weathersimpleapp.data.repository

import com.example.weathersimpleapp.models.dto.city.City

interface CityRepository {
    fun getCityList() : List<City>
    fun getSearchCityList(searchText : String) : List<City>
}