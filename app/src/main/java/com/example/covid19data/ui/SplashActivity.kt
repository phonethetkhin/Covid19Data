package com.example.covid19data.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.utils.getFlags
import com.example.covid19data.vModel.CountryViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val vModel = ViewModelProviders.of(this@SplashActivity).get(CountryViewModel::class.java)
        vModel.getCountryAPILiveData()
        vModel.countryAPILiveData.observe(this@SplashActivity, Observer {
            it?.let {
                val countryEntity =
                    CountriesEntity(
                        0,
                        it.countrylist
                    , getFlags()
                    )
                vModel.insertCountries(countryEntity)
            }
        }
        )


        GlobalScope.launch {


            delay(7000L)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)

            startActivity(intent)

            finish()

        }
    }
}



