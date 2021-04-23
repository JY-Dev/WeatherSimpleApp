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
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class CityFragment : BaseFragment<FragmentCityBinding>(R.layout.fragment_city) {
    private val cityViewModel: CityViewModel by viewModel()
    private lateinit var cityAdapter: CityAdapter
    private val gotoWeatherPage: (City) -> Unit = {
        CityFragmentDirections.actionFragmentCityToFragmentWeather(it).navigate()
    }
    private val searchSubject: PublishSubject<String> by lazy {
        PublishSubject.create<String>().apply {
            debounce(500L,TimeUnit.MILLISECONDS).
            observeOn(AndroidSchedulers.mainThread()).subscribe({
                cityViewModel.requestSearchCityList(it)
            },{
                it.printStackTrace()
            })
        }
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
        cityViewModel.searchText.observe(viewLifecycleOwner, Observer(searchSubject::onNext))
    }

}