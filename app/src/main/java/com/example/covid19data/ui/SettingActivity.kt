package com.example.covid19data.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covid19data.R
import com.example.covid19data.utils.setCheckedtoSelectedColor
import com.example.covid19data.utils.setStringPref
import kotlinx.android.synthetic.main.activity_setting.*
import com.example.covid19data.utils.*

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


    }

    override fun onBackPressed() {
        finish()
        startActivity(Intent(this,MainActivity::class.java))
    }
}
