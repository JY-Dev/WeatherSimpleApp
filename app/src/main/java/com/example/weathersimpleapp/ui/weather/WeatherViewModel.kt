package com.example.weathersimpleapp.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersimpleapp.data.repository.WeatherRepository
import com.example.weathersimpleapp.models.dto.city.City
import com.example.weathersimpleapp.models.mapping.Weather
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

class WeatherViewModel(val city: City, private val weatherRepository: WeatherRepository) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _weather = MutableLiveData<Weather>()
    val weather: LiveData<Weather> = _weather

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
            }).addComposite()
    }

    private fun Disposable.addComposite() =
        compositeDisposable::add

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}