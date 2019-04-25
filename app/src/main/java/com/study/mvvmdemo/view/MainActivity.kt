package com.study.mvvmdemo.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.study.mvvmdemo.R
import com.study.mvvmdemo.databinding.ActivityMainBinding
import com.study.mvvmdemo.model.data.Onclick
import com.study.mvvmdemo.model.remote.WeatherService
import com.study.mvvmdemo.viewmodel.OnclikViewModel
import com.study.mvvmdemo.viewmodel.WeatherViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewMode: OnclikViewModel
    private lateinit var mViewMode2: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /////model
        val onclick = Onclick("me", 0)
        ///ViewModel
        mViewMode = OnclikViewModel(onclick)
        ///binding


        val remote = Retrofit.Builder()
            .baseUrl("http://www.weather.com.cn")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherService::class.java)

        mViewMode2 = WeatherViewModel(remote)
        mBinding.vm = mViewMode
        mBinding.remote = mViewMode2

    }
}
