package com.example.weathersimpleapp.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersimpleapp.data.repository.WeatherRepository
import com.example.weathersimpleapp.models.city.City
import com.example.weathersimpleapp.models.mapping.WeatherMapping

class WeatherViewModel(val city: City, private val weatherRepository: WeatherRepository) :
    ViewModel() {

    private val _weather = MutableLiveData<WeatherMapping>()
    val weather: LiveData<WeatherMapping> = _weather

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing : LiveData<Boolean> = _isRefreshing

    init {
        requestWeather()
    }

    fun requestWeather() {
        _isRefreshing.value = true
        weatherRepository.getWeatherFromCityId(city.id)
            .subscribe({
                _weather.value = it
                _isRefreshing.value = false
            }, { throwable ->
                throwable.printStackTrace()
                _isRefreshing.value = false
            })
    }
}