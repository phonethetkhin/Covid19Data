package com.example.covid19data.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19data.R
import com.example.covid19data.utils.getTheme
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (getTheme(this)) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.RedTheme)
        }
        setContentView(R.layout.activity_about)
        txtDeveloperName.setOnClickListener {
            val url = "https://www.facebook.com/snow.cat.9212"
            val i = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
            startActivity(i)
        }
    }
}
