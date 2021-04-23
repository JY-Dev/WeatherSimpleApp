package com.example.weathersimpleapp.di

import com.example.weathersimpleapp.data.network.weather.WeatherRemoteDataSource
import com.example.weathersimpleapp.data.network.weather.WeatherRemoteDataSourceImpl
import com.example.weathersimpleapp.data.network.weather.WeatherService
import com.example.weathersimpleapp.data.repository.CityRepositoryImpl
import com.example.weathersimpleapp.data.repository.WeatherRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 20L
private const val BASE_URL = "http://api.openweathermap.org"

val networkModule = module {
    single {
        OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(WeatherService::class.java) }
    single {
        WeatherRemoteDataSourceImpl(
            get<WeatherService>()
        )
    }
    single { CityRepositoryImpl(androidContext()) }
    single { WeatherRepositoryImpl(get<WeatherRemoteDataSource>()) }
}