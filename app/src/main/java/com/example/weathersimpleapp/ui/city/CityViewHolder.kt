package com.example.weathersimpleapp.ui.city

import androidx.recyclerview.widget.RecyclerView
import com.example.weathersimpleapp.databinding.ItemCityBinding
import com.example.weathersimpleapp.models.dto.city.City

class CityViewHolder(private val itemCityBinding: ItemCityBinding , private val weatherOnclick : (city : City) -> Unit) : RecyclerView.ViewHolder(itemCityBinding.root) {
    fun bind(item : City){
        itemCityBinding.apply {
            city = item
            weatherBtn.setOnClickListener {
                weatherOnclick(item)
            }
        }
    }
}