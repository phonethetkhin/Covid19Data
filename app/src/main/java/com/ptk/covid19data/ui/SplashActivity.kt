@file:Suppress("DEPRECATION")

package com.ptk.covid19data.ui

import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import com.ptk.covid19data.R
import com.ptk.covid19data.interfaces.DialogToActivity
import com.ptk.covid19data.room.entities.CountriesEntity
import com.ptk.covid19data.utils.getStringPref
import com.ptk.covid19data.utils.getTheme
import com.ptk.covid19data.utils.isNetworkActive
import com.ptk.covid19data.utils.setApplicationLanguage
import com.ptk.covid19data.vModel.CountryViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SplashActivity : AppCompatActivity(), DialogToActivity {
    lateinit var alertDialog: LottieAlertDialog
    lateinit var customDialog: CustomDialogClass
    private lateinit var chooseButton: Button
    private lateinit var countriesSpinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (getTheme(this)) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.RedTheme)
        }
        setContentView(R.layout.activity_splash)
        val value = getStringPref(this, "countryname", "countryname", "")

        customDialog = CustomDialogClass(this, this)
        customDialog.setDialogToActivity(this)
        if (isNetworkActive(this)) {
            if (value.isNullOrBlank()) {
                setCustomSpinnerDialog()

            } else {
                mainFunction()
            }
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

    private fun setCustomSpinnerDialog() {

        val window: Window? = customDialog.window
        customDialog.show()
        window!!.setLayout(
            WindowManager.LayoutParams.FILL_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )


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
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    override fun onClick(click: Boolean) {
        if (click) {
            customDialog.dismiss()
        }
    }


}
