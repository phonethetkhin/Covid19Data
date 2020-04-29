package com.example.covid19data.utils

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

fun getStringPref(context: Context, name: String, key: String, defaultvalue: String): String? {
    val pref = context.getSharedPreferences(name, Context.MODE_PRIVATE)
    return pref.getString(key, defaultvalue)
}
