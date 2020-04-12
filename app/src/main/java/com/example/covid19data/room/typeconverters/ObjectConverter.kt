package com.example.covid19data.room.typeconverters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.covid19data.models.CountryDetailModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ObjectConverter {
        @TypeConverter
        fun fromCountryLangList(countryLang: List<CountryDetailModel?>?): String? {
            if (countryLang == null) {
                return null
            }
            val gson = Gson()
            val type: Type =
                object : TypeToken<List<CountryDetailModel?>?>() {}.type
            return gson.toJson(countryLang, type)
        }

        @TypeConverter
        fun toCountryLangList(countryLangString: String?): List<CountryDetailModel>? {
            if (countryLangString == null) {
                return null
            }
            val gson = Gson()
            val type: Type =
                object : TypeToken<List<CountryDetailModel?>?>() {}.type
            return gson.fromJson(countryLangString, type)
        }


}