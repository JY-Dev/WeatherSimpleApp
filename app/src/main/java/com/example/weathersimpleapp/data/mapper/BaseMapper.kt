package com.example.weathersimpleapp.data.mapper

interface BaseMapper<T> {
    fun getMappingData() : T
}