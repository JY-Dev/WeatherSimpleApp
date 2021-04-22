package com.example.weathersimpleapp.di

import com.example.weathersimpleapp.ui.city.CityViewModel
import com.example.weathersimpleapp.ui.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CityViewModel()
    }
    viewModel {
        WeatherViewModel(weatherRepository = get())
    }
}