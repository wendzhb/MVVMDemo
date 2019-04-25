package com.study.mvvmdemo.model.local.dao

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 * Created by zhb on 2019/4/24.
 */
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetAll(postinfo: List<PostEntity>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserttWeather(postinfo: PostEntity)

    @Query("SELECT * FROM postentity")
    fun getWeathInfo(): Single<PostEntity>
}