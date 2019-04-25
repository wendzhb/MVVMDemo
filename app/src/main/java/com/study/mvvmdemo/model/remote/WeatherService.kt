package com.study.mvvmdemo.model.remote

import com.study.mvvmdemo.model.data.WeatherInfoData
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by zhb on 2019/4/24.
 */
interface WeatherService {
    //获取天气
    @GET("/data/sk/101190408.html")
    fun getWeatherInfo(): Single<WeatherInfoData>
}