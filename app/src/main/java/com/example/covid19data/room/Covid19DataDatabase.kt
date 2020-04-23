package com.example.covid19data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.covid19data.room.dao.CountriesDao
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.room.typeconverters.ObjectConverter

@Database(entities = [CountriesEntity::class], version = 1, exportSchema = false)
@TypeConverters(ObjectConverter::class)

abstract class Covid19DataDatabase : RoomDatabase() {
    abstract fun countriesDao(): CountriesDao

    companion object {
        @Volatile
        var Instance: Covid19DataDatabase? = null
        fun getCovid19DB(context: Context): Covid19DataDatabase? {
            if (Instance == null) {
                synchronized(this)
                {
                    Instance = Room.databaseBuilder(
                        context,
                        Covid19DataDatabase::class.java,
                        "covid19Data.db"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return Instance
        }

        fun destroyDB() {
            Instance = null
        }
    }

}
