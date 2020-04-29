package com.example.covid19data.ui

import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.utils.getStringExtra
import com.example.covid19data.utils.getTimeZone
import com.example.covid19data.utils.setToolbarTitleAndBackArrow
import com.example.covid19data.vModel.CountryDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_country_detail.*
import com.example.covid19data.utils.*



class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (getTheme(this)) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.GreenTheme)
        }
        setContentView(R.layout.activity_country_detail)
        val toolbar = tlbToolbar2 as Toolbar

        setSupportActionBar(toolbar)

        val name = getStringExtra(this,"name")
        val flag = getStringExtra(this,"flag")
        Picasso.get().load(flag).into(imgCountryFlag)


setToolbarTitleAndBackArrow(this,toolbar,name,supportActionBar!!)



        val vModel = ViewModelProviders.of(this).get(CountryDetailViewModel::class.java)
        vModel.getCountryDetail(name)
        vModel.countryDetailLiveData.observe(this, Observer {

            txtTotalCases.text = it.confirmedModel.totalCases.toString()
            txtRecovered.text = it.recoveredModel.totalRecovered.toString()
            txtDeaths.text = it.deathsModel.totalDeaths.toString()
            txtLastUpdated.text = getTimeZone(it.lastestUpdate)
            txtCountryName.text = name

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


}
