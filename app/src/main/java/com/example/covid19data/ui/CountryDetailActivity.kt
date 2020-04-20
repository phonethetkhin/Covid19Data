package com.example.covid19data.ui

import android.graphics.BitmapFactory
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.utils.getTimeZone
import com.example.covid19data.vModel.CountryDetailViewModel
import kotlinx.android.synthetic.main.activity_country_detail.*


class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
        val toolbar = tlbToolbar2 as Toolbar

        setSupportActionBar(toolbar)

        val name: String = intent.getStringExtra("name")

        val b = intent!!.getByteArrayExtra("flag")

        val bmp = BitmapFactory.decodeByteArray(b, 0, b!!.size)
        val countryFlag = findViewById<ImageView>(R.id.imgCountryFlag)

        countryFlag.setImageBitmap(bmp)

        supportActionBar!!.title = Html.fromHtml("<font color='#FFFFFF'>$name </font>")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.navigationIcon!!.setColorFilter(resources.getColor(R.color.white), PorterDuff.Mode.SRC_ATOP)


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
        when (item.itemId)
        {
            android.R.id.home -> super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


}
