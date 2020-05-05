@file:Suppress("DEPRECATION")

package com.ptk.covid19data.ui

import android.content.Intent
import android.os.Bundle
import android.os.Process
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ptk.covid19data.R
import com.ptk.covid19data.room.entities.CountriesEntity
import com.ptk.covid19data.utils.getStringPref
import com.ptk.covid19data.utils.getTheme
import com.ptk.covid19data.utils.isNetworkActive
import com.ptk.covid19data.utils.setApplicationLanguage
import com.ptk.covid19data.vModel.CountryViewModel
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SplashActivity : AppCompatActivity() {
    lateinit var alertDialog: LottieAlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (getTheme(this)) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.RedTheme)
        }
        setContentView(R.layout.activity_splash)

        if (isNetworkActive(this)) {
            mainFunction()
        } else {
            showDialog()

        }
    }

    private fun mainFunction() {
        val lang = getStringPref(this, "lang", "lang", "en")
        setApplicationLanguage(lang, this)

        val vModel =
            ViewModelProviders.of(this@SplashActivity).get(CountryViewModel::class.java)
        vModel.getCountryUtilsLiveData(this)
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


    private fun showDialog() {
        alertDialog = LottieAlertDialog.Builder(this, DialogTypes.TYPE_WARNING)
            .setTitle("No Connection !!!")
            .setDescription("You need Internet Connection to view latest data")
            .setPositiveText("OK,Check again")
            .setPositiveListener(object : ClickListener {
                override fun onClick(dialog: LottieAlertDialog) {
                    alertDialog.dismiss()

                    if (isNetworkActive(this@SplashActivity)) {
                        mainFunction()
                    } else {
                        alertDialog.show()
                    }
                }
            })
            .setNegativeText("Cancel")
            .setNegativeListener(object : ClickListener {
                override fun onClick(dialog: LottieAlertDialog) {
                    alertDialog.dismiss()

                    finishAffinity()

                    Process.killProcess(Process.myPid())
                }
            })
            .build()
        alertDialog.show()
    }


}
