package com.example.weathersimpleapp.ui.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weathersimpleapp.R
import com.example.weathersimpleapp.databinding.FragmentWeatherBinding
import com.example.weathersimpleapp.ui.base.BaseFragment

class WeatherFragment : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            lifecycleOwner = this@WeatherFragment
        }.root
    }

}