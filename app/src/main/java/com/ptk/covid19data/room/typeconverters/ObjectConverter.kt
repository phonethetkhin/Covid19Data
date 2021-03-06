package com.ptk.covid19data.room.typeconverters

import androidx.room.TypeConverter
import com.ptk.covid19data.models.CountryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class ObjectConverter {
    @TypeConverter
    fun fromCountryLangList(countryLang: List<CountryModel?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gSon = Gson()
        val type: Type =
            object : TypeToken<List<CountryModel?>?>() {}.type
        return gSon.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<CountryModel>? {
        if (countryLangString == null) {
            return null
        }
        val gSon = Gson()
        val type: Type =
            object : TypeToken<List<CountryModel?>?>() {}.type
        return gSon.fromJson(countryLangString, type)
    }

    @TypeConverter
    fun fromListToString(countryLang: List<String?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gSon = Gson()
        val type: Type =
            object : TypeToken<List<String?>?>() {}.type
        return gSon.toJson(countryLang, type)
    }

    @TypeConverter
    fun toListToString(countryLangString: String?): List<String>? {
        if (countryLangString == null) {
            return null
        }
        val gSon = Gson()
        val type: Type =
            object : TypeToken<List<String?>?>() {}.type
        return gSon.fromJson(countryLangString, type)
    }


}