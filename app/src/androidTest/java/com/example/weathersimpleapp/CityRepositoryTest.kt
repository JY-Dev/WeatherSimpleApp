package com.example.weathersimpleapp

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weathersimpleapp.data.repository.CityRepository
import com.example.weathersimpleapp.data.repository.CityRepositoryImpl

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CityRepositoryTest {
    @Test
    fun `CityRepository 에서 첫번째 City의 name은 Hurzuf 이어야 한다`() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val repository = CityRepositoryImpl(appContext)
        val cityList = repository.getCityList()
        assertEquals("Hurzuf", cityList[0].name)
    }

    @Test
    fun `CityRepository 에서 Hurzuf로 검색한 첫번째 결과는 Hurzuf 이어야 한다`() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val repository = CityRepositoryImpl(appContext)
        val cityList = repository.getSearchCityList("Hurzuf")
        assertEquals("Hurzuf", cityList[0].name)
    }

    @Test
    fun `CityRepository 에서 hurzuf 로 검색한 첫번째 결과는 Hurzuf 이어야 한다`() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val repository = CityRepositoryImpl(appContext)
        val cityList = repository.getSearchCityList("hurzuf")
        assertEquals("Hurzuf", cityList[0].name)
    }
}