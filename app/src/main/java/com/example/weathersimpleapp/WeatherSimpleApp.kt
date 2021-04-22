package com.example.weathersimpleapp

import android.app.Application
import com.example.weathersimpleapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherSimpleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WeatherSimpleApp)
            modules(listOf(networkModule))
        }
    }
}