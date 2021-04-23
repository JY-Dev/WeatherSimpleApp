package com.example.weathersimpleapp

import com.example.weathersimpleapp.util.getCelsiusString
import com.example.weathersimpleapp.util.getMeterPerSecondString
import com.example.weathersimpleapp.util.kelvinToCelsius
import org.junit.Test

class WeatherUtilTest {

    @Test
    fun `getCelsiusString celsius 값을 30으로 넣어주면 결과값은 30℃`(){
        assert(getCelsiusString(30) == "30℃")
    }

    @Test
    fun `getMeterPerSecondString 에 value 을 30으로 넣어주면 결과값은 30meterPerSecond`(){
        println("test:${getMeterPerSecondString(30f)}")
        assert(getMeterPerSecondString(30f) == "30.0m/s")
    }

    @Test
    fun `kelvinToCelsius kelvin 값을 300으로 넣어주면 결과값은 27`(){
        assert(kelvinToCelsius(300f) == 27)
    }
}