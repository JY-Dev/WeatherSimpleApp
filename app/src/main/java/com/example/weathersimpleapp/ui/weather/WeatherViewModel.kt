package com.example.weathersimpleapp.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersimpleapp.data.repository.WeatherRepository
import com.example.weathersimpleapp.models.city.City
import com.example.weathersimpleapp.models.response.WeatherResponse
import com.example.weathersimpleapp.models.weather.Weather

class WeatherViewModel(val city: City ,private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> = _weather

    init {
        city.let {
            weatherRepository.getWeatherFromCityIdService(it.id)
                .subscribe((_weather::setValue), { throwable ->
                    throwable.printStackTrace()
                })
        }
    }
    fun getWeather() {

    }
}