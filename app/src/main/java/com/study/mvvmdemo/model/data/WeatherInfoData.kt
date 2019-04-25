package com.study.mvvmdemo.model.data

/**
 * Created by zhb on 2019/4/24.
 */
data class WeatherInfoData(
    val weatherinfo: Weatherinfo
)

data class Weatherinfo(
    val AP: String,
    val Radar: String,
    val SD: String,
    val WD: String,
    val WS: String,
    val WSE: String,
    val city: String,
    val cityid: String,
    val isRadar: String,
    val njd: String,
    val sm: String,
    val temp: String,
    val time: String
)