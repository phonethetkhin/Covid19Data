@file:Suppress("DEPRECATION")

package com.example.covid19data.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.utils.getStringPref
import com.example.covid19data.utils.getTheme
import com.example.covid19data.utils.setApplicationLanguage
import com.example.covid19data.utils.setStringPref
import com.example.covid19data.vModel.CountryViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (getTheme(this)) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.RedTheme)
        }
        setContentView(R.layout.activity_splash)
        mainFunction()
    }

    private fun mainFunction() {
        val lang = getStringPref(this, "lang", "lang", "en")
        setApplicationLanguage(lang, this)

        val vModel =
            ViewModelProviders.of(this@SplashActivity).get(CountryViewModel::class.java)
        vModel.getCountryUtilsLiveData()
        vModel.countryUtilsLiveData.observe(this, Observer {
            vModel.insertCountries(CountriesEntity(0, it))
        })

        GlobalScope.launch {

            delay(7000L)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)

            startActivity(intent)

            finish()

        }
    }


}
