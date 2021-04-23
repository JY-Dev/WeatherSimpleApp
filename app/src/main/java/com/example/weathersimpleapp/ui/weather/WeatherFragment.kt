package com.example.weathersimpleapp.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.weathersimpleapp.R
import com.example.weathersimpleapp.databinding.FragmentWeatherBinding
import com.example.weathersimpleapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherFragment : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather) {
    val args : WeatherFragmentArgs by navArgs()
    private val weatherViewModel : WeatherViewModel by viewModel { parametersOf(args.city) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            lifecycleOwner = viewLifecycleOwner
            viewModel = weatherViewModel
            initView()
        }.root
    }

    private fun FragmentWeatherBinding.initView(){
        swipeRefreshLayout.setOnRefreshListener {
            weatherViewModel.requestWeather()
        }
    }

}