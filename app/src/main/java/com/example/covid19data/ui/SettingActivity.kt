package com.example.covid19data.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.covid19data.R
import com.example.covid19data.utils.setCheckedtoSelectedColor
import com.example.covid19data.utils.setStringPref
import kotlinx.android.synthetic.main.activity_setting.*
import com.example.covid19data.utils.*
import kotlinx.android.synthetic.main.activity_country_detail.*
import java.util.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val theme = getTheme(this)
        when (theme) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.GreenTheme)
        }
        setContentView(R.layout.activity_setting)
        val toolbar = include2 as Toolbar

        setSupportActionBar(toolbar)
        setToolbarTitleAndBackArrow(this,toolbar,"Setting",supportActionBar!!)


        // color
        setCheckedtoSelectedColor(this,theme,ibtGreen,ibtBlue,ibtRed)

        ibtRed.setOnClickListener {
            setCheckedtoSelectedColor(this,"Red",ibtGreen,ibtBlue,ibtRed)
            setStringPref(this,"theme","color_name","Red")
            recreate()
        }
        ibtBlue.setOnClickListener {
            setCheckedtoSelectedColor(this,"Blue",ibtGreen,ibtBlue,ibtRed)
            setStringPref(this,"theme","color_name","Blue")
            recreate()
        }
        ibtGreen.setOnClickListener {
            setCheckedtoSelectedColor(this,"Green",ibtGreen,ibtBlue,ibtRed)
            setStringPref(this,"theme","color_name","Green")
            recreate()
        }
        btnEnglish.setOnClickListener {
            setApplicationLanguage("en",this)
            setStringPref(this,"lang","lang","en")
            recreate()
        }
        btnMyanmarUni.setOnClickListener {

            setApplicationLanguage("mu",this)
            setStringPref(this,"lang","lang","mu")

            recreate()
        }
        btnMyanmarZaw.setOnClickListener {
            setApplicationLanguage("mz",this)
            setStringPref(this,"lang","lang","mz")

            recreate()
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onBackPressed() {
        finish()
        startActivity(Intent(this,MainActivity::class.java))
    }

}
