package com.example.weathersimpleapp.data.repository

import android.content.Context
import com.example.weathersimpleapp.models.city.City
import com.example.weathersimpleapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import java.util.*

class CityRepositoryImpl(private val context : Context) : CityRepository {
    override fun getCityList(): List<City> =
        getJsonDataFromAsset(context, "citylist.json").let {
            Gson().fromJson(it, Array<City>::class.java).toList()
        }

    override fun getSearchCityList(searchText: String) =
        getCityList().filter { it.name.toLowerCase(Locale.getDefault()).contains(searchText.toLowerCase(Locale.getDefault())) }
}