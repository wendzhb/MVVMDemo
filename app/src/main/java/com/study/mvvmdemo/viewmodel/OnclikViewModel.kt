package com.study.mvvmdemo.viewmodel

import android.databinding.ObservableField
import com.study.mvvmdemo.model.data.Onclick

/**
 * Created by zhb on 2019/4/24.
 * @desc 处理数据V(MVVM 中的VM),负责提供View中需要处理的数据
 */
class OnclikViewModel(val onlick: Onclick) {
    /******data******/
    val info = ObservableField<String>("\"${onlick.who}点击了${onlick.count}次\"")

    /******binding******/
    fun click() {
        onlick.count++
        info.set("\"${onlick.who}点击了${onlick.count}次\"")
    }

}