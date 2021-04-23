package com.example.weathersimpleapp.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.weathersimpleapp.R
import com.example.weathersimpleapp.databinding.FragmentCityBinding
import com.example.weathersimpleapp.models.city.City
import com.example.weathersimpleapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityFragment : BaseFragment<FragmentCityBinding>(R.layout.fragment_city) {
    private val cityViewModel: CityViewModel by viewModel()
    private lateinit var cityAdapter: CityAdapter
    private val gotoWeatherPage : (City) -> Unit = {
        CityFragmentDirections.actionFragmentCityToFragmentWeather(it).navigate()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            lifecycleOwner = this@CityFragment
            viewModel = cityViewModel
            cityRecyclerView.adapter = CityAdapter(gotoWeatherPage).apply {
                cityAdapter = this
            }
            observeData()
        }.root
    }

    private fun observeData() {
        cityViewModel.cityList.observe(viewLifecycleOwner, Observer(cityAdapter::setCityList))
    }

}