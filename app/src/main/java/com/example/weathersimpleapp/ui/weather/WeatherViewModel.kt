package com.example.weathersimpleapp.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersimpleapp.data.repository.WeatherRepository
import com.example.weathersimpleapp.models.city.City
import com.example.weathersimpleapp.models.mapping.WeatherMapping
import com.example.weathersimpleapp.models.response.WeatherResponse
import com.example.weathersimpleapp.models.weather.Weather

class WeatherViewModel(val city: City ,private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _weather = MutableLiveData<WeatherMapping>()
    val weather: LiveData<WeatherMapping> = _weather

    init {
        getWeather()
    }

    fun getWeather() {
        weatherRepository.getWeatherFromCityId(city.id)
            .subscribe((_weather::setValue), { throwable ->
                throwable.printStackTrace()
            })
    }
}