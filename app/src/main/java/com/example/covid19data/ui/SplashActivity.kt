package com.example.covid19data.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Process
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.utils.ERRORDIALOGREQUESTCODE
import com.example.covid19data.utils.getFlags
import com.example.covid19data.vModel.CountryViewModel
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.security.ProviderInstaller
import com.labters.lottiealertdialoglibrary.ClickListener
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity(), ProviderInstaller.ProviderInstallListener {
    private var retryProviderInstall: Boolean = false
    private lateinit var alertDialog: LottieAlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ProviderInstaller.installIfNeededAsync(this, this)

    }

    override fun onProviderInstallFailed(p0: Int, p1: Intent?) {
        GoogleApiAvailability.getInstance().apply {
            if (Build.VERSION.SDK_INT <= 19 && isUserResolvableError(p0)) {
                // Recoverable error. Show a dialog prompting the user to
                // install/update/enable Google Play services.


                alertDialog = LottieAlertDialog.Builder(this@SplashActivity, DialogTypes.TYPE_ERROR)
                    .setTitle("App not compatible")

                    .setDescription("Your device must have google play service or Android Version must be higher than 4.4(KitKat)")
                    .setPositiveText("OK")
                    .setPositiveListener(object : ClickListener {
                        override fun onClick(dialog: LottieAlertDialog) {
                            alertDialog.dismiss()
                            finishAffinity()

                            Process.killProcess(Process.myPid())
                        }
                    })
                    .build()
                alertDialog.show()


                onProviderInstallerNotAvailable()

            } else {
                onProviderInstallerNotAvailable()
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ERRORDIALOGREQUESTCODE) {
            // Adding a fragment via GoogleApiAvailability.showErrorDialogFragment
            // before the instance state is restored throws an error. So instead,
            // set a flag here, which will cause the fragment to delay until
            // onPostResume.
            retryProviderInstall = true
        }
    }

    override fun onProviderInstalled() {

        val vModel = ViewModelProviders.of(this@SplashActivity).get(CountryViewModel::class.java)
        vModel.getCountryAPILiveData()
        vModel.countryAPILiveData.observe(this@SplashActivity, Observer {
            it?.let {
                val countryEntity =
                    CountriesEntity(
                        0,
                        it.countryList
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

    override fun onPostResume() {
        super.onPostResume()
        if (retryProviderInstall) {
            // We can now safely retry installation.
            ProviderInstaller.installIfNeededAsync(this, this)
        }
        retryProviderInstall = false
    }

    private fun onProviderInstallerNotAvailable() {
        // This is reached if the provider cannot be updated for some reason.
        // App should consider all HTTP communication to be vulnerable, and take
        // appropriate action.
    }

}



