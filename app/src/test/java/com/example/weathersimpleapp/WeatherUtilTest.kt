package com.example.weathersimpleapp

import com.example.weathersimpleapp.util.fahrenheitToCelsius
import com.example.weathersimpleapp.util.getCelsiusString
import com.example.weathersimpleapp.util.getMeterPerSecondString
import org.junit.Test

class WeatherUtilTest {

    @Test
    fun `getCelsiusString celsius 값을 30으로 넣어주면 결과값은 30℃`(){
        assert(getCelsiusString(30f) == "30℃")
    }

    @Test
    fun `getMeterPerSecondString 에 value 을 30으로 넣어주면 결과값은 30meterPerSecond`(){
        assert(getMeterPerSecondString(30f) == "30m/s")
    }

    @Test
    fun `fahrenheitToCelsius fahrenheit 값을 86으로 넣어주면 결과값은 30`(){
        assert(fahrenheitToCelsius(86f) == 30f)
    }
}