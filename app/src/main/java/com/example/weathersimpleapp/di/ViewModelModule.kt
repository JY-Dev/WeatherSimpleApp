package com.example.weathersimpleapp.di

import com.example.weathersimpleapp.models.city.City
import com.example.weathersimpleapp.ui.city.CityViewModel
import com.example.weathersimpleapp.ui.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CityViewModel()
    }
    viewModel { (city : City) ->
        WeatherViewModel(city,weatherRepository = get())
    }
}