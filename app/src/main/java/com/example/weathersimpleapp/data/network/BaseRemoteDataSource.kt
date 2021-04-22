package com.example.weathersimpleapp.data.network

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

open class BaseRemoteDataSource {
    protected fun <T> Single<T>.setNetworkThread() : Single<T> = observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
}