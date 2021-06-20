package com.ptk.covid19data.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.chivorn.smartmaterialspinner.SmartMaterialSpinner
import com.ptk.covid19data.R
import com.ptk.covid19data.interfaces.DialogToActivity
import com.ptk.covid19data.room.entities.CountriesEntity
import com.ptk.covid19data.utils.getStringPref
import com.ptk.covid19data.utils.setApplicationLanguage
import com.ptk.covid19data.utils.setStringPref
import com.ptk.covid19data.utils.setToast
import com.ptk.covid19data.vModel.CountryViewModel
import kotlinx.android.synthetic.main.customdialog.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CustomDialogClass(private val appCompatActivity: AppCompatActivity, context: Context) :
    Dialog(context) {
    private var spProvince: SmartMaterialSpinner<String>? = null
    private lateinit var dialogToActivity: DialogToActivity

    init {
        setCancelable(false)
    }

    fun setDialogToActivity(listener: DialogToActivity) {
        this.dialogToActivity = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.customdialog)
        initSpinner()

    }

    private fun initSpinner() {
        spProvince = findViewById(R.id.spnCountries)
        val countriesList: MutableList<String> = ArrayList<String>()
        val vModel = ViewModelProviders.of(appCompatActivity).get(CountryViewModel::class.java)
        vModel.getCountryUtilsLiveData(context)
        vModel.countryUtilsLiveData.observe(appCompatActivity, Observer {
            it?.let {
                for (i in it.indices) {
                    countriesList.add(it[i].name)
                }
            }
        })

        spProvince!!.item = countriesList

        btnChoose.setOnClickListener {
            if (spnCountries.selectedItem == null) {
                setToast(context, "You must choose a country", Toast.LENGTH_SHORT)
            } else {
                val result = spnCountries.selectedItem.toString()
                setStringPref(context, "countryname", "countryname", result)
                mainFunction()
            }
            this.dismiss()

        }


        btnSkip.setOnClickListener {
            setToast(
                context,
                "Default Country is Burma, You can change it later.",
                Toast.LENGTH_SHORT
            )
            setStringPref(context, "countryname", "countryname", "Burma")
            mainFunction()
        }
        this.dismiss()

    }

    private fun mainFunction() {
        val lang = getStringPref(context, "lang", "lang", "en")
        setApplicationLanguage(lang, context)

        val vModel =
            ViewModelProviders.of(appCompatActivity).get(CountryViewModel::class.java)
        vModel.getCountryUtilsLiveData(context)
        vModel.countryUtilsLiveData.observe(appCompatActivity, Observer {

            vModel.insertCountries(CountriesEntity(0, it))
        })

            val intent = Intent(context, MainActivity::class.java)

            context.startActivity(intent)

            appCompatActivity.finish()

        }

}