package com.example.weathersimpleapp.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersimpleapp.data.repository.CityRepository
import com.example.weathersimpleapp.models.city.City

class CityViewModel(private val cityRepository: CityRepository) : ViewModel() {
    private val _cityList = MutableLiveData<List<City>>()
    val cityList : LiveData<List<City>> = _cityList

    init {
        getCityList()
    }

    fun getSearchCityList(searchText : String){
        cityRepository.getSearchCityList(searchText).let(_cityList::setValue)
    }

    fun getCityList(){
        cityRepository.getCityList().let(_cityList::setValue)
    }

}