package com.example.weathersimpleapp.ui.city

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weathersimpleapp.R
import com.example.weathersimpleapp.databinding.FragmentCityBinding
import com.example.weathersimpleapp.ui.base.BaseFragment

class CityFragment : BaseFragment<FragmentCityBinding>(R.layout.fragment_city) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            lifecycleOwner = this@CityFragment
        }.root
    }

}