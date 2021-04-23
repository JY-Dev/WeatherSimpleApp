package com.example.weathersimpleapp.ui.city

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weathersimpleapp.R
import com.example.weathersimpleapp.models.city.City

class CityAdapter(private val weatherOnclick: (city: City) -> Unit) :
    RecyclerView.Adapter<CityViewHolder>() {
    private var cityList = listOf<City>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder =
        CityViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_city,
                parent,
                false
            ), weatherOnclick
        )

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position])
    }

    override fun getItemCount(): Int =
        cityList.size

    fun setCityList(cityList : List<City>){
        this.cityList = cityList
        notifyDataSetChanged()
    }
}