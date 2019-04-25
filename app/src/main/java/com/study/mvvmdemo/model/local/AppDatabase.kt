package com.study.mvvmdemo.model.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.study.mvvmdemo.model.local.dao.PostDao
import com.study.mvvmdemo.model.local.dao.PostEntity

/**
 * Created by zhb on 2019/4/24.
 */
@Database(entities = arrayOf(PostEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun WeatherDao(): PostDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app.db")
                .build()
    }
}