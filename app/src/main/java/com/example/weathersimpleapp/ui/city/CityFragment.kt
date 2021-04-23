package com.example.weathersimpleapp.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.weathersimpleapp.R
import com.example.weathersimpleapp.databinding.FragmentCityBinding
import com.example.weathersimpleapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityFragment : BaseFragment<FragmentCityBinding>(R.layout.fragment_city) {
    private val cityViewModel : CityViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            lifecycleOwner = this@CityFragment
            viewModel = cityViewModel
            observeData()
        }.root
    }

    private fun observeData(){
        cityViewModel.cityList.observe(viewLifecycleOwner , Observer {
            it.forEach {
                println("name:${it.name}")
            }
        })
    }

}