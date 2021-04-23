package com.example.weathersimpleapp.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersimpleapp.data.repository.CityRepository
import com.example.weathersimpleapp.models.city.City

class CityViewModel(private val cityRepository: CityRepository) : ViewModel() {
    private val _cityList = MutableLiveData<List<City>>()
    val cityList : LiveData<List<City>> = _cityList
    val searchText = MutableLiveData<String>()

    init {
        requestCityList()
    }

    fun requestSearchCityList(searchText : String){
        cityRepository.getSearchCityList(searchText).let(_cityList::setValue)
    }

    fun requestCityList(){
        cityRepository.getCityList().let(_cityList::setValue)
    }

}