package com.ptk.covid19data.utils

import android.content.Context


fun getTheme(context: Context): String? {

    val pref = context.getSharedPreferences("theme", Context.MODE_PRIVATE)

    return pref.getString("color_name", "")
}

fun setStringPref(context: Context, name: String, key: String, value: String) {
    val pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putString(key, value)
    editor.apply()
}

fun getStringPref(context: Context, name: String, key: String, defaultValue: String): String? {
    val pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    return pref.getString(key, defaultValue)
}

fun setBooleanPref(context: Context, name: String, key: String, value: Boolean) {
    val pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    val editor = pref.edit()
    editor.putBoolean(key, value)
    editor.apply()
}

fun getBooleanPref(context: Context, name: String, key: String, defaultValue: Boolean): Boolean? {
    val pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    return pref.getBoolean(key, defaultValue)
}