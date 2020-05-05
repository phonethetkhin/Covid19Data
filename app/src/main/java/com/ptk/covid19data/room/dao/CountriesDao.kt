package com.ptk.covid19data.room.dao

import androidx.room.*
import com.ptk.covid19data.room.entities.CountriesEntity

@Dao
interface CountriesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountry(countriesEntity: CountriesEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCountry(countriesEntity: CountriesEntity)

    @Delete
    suspend fun deleteCountry(countriesEntity: CountriesEntity)

    @Query("SELECT * FROM tbl_countries")
    suspend fun getAllCountries(): CountriesEntity?


    @Query("DELETE FROM tbl_countries")
    suspend fun deleteAllCountries()


}