package com.study.mvvmdemo.viewmodel

import android.databinding.ObservableField
import com.study.mvvmdemo.model.data.WeatherInfoData
import com.study.mvvmdemo.model.remote.WeatherService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by zhb on 2019/4/24.
 */
class WeatherViewModel(val remote: WeatherService) {

    /******data******/
    val weatherinfo = ObservableField<String>()

    /******binding******/
    fun loadWeather() {
        remote.getWeatherInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { t: WeatherInfoData? ->
                weatherinfo.set(t?.let { it.weatherinfo.toString() })
            }, { t: Throwable? ->
                weatherinfo.set(t?.message ?: "error")
            })
    }
}