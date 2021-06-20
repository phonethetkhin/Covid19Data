package com.ptk.covid19data.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import com.ptk.covid19data.R
import com.ptk.covid19data.utils.getStringExtra
import com.ptk.covid19data.utils.getTheme
import kotlinx.coroutines.*


class NewsDetailActivity : AppCompatActivity() {
    lateinit var alertDialog: LottieAlertDialog

    lateinit var wbvNews: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (getTheme(this)) {
            "Green" -> setTheme(R.style.GreenTheme)
            "Blue" -> setTheme(R.style.BlueTheme)
            "Red" -> setTheme(R.style.RedTheme)
            else -> setTheme(R.style.RedTheme)
        }
        setContentView(R.layout.activity_news_detail)
        wbvNews = findViewById(R.id.wbvNews)

        val url = getStringExtra(this, "url")
        CoroutineScope(Dispatchers.Main).launch {
            showProgressLottieDialog(this@NewsDetailActivity)
            withContext(Dispatchers.Main) {
                mainFunction(url)
            }
            delay(1000L)
            alertDialog.dismiss()
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun mainFunction(url: String) {
        val webSettings: WebSettings = wbvNews.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        wbvNews.isVerticalScrollBarEnabled = true
        wbvNews.webViewClient = WebViewClient()
        wbvNews.settings.loadWithOverviewMode = true
        wbvNews.settings.useWideViewPort = true
        wbvNews.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        wbvNews.webChromeClient = WebChromeClient()
        wbvNews.loadUrl(url)
    }

    override fun onBackPressed() {
        if (wbvNews.canGoBack()) {
            wbvNews.goBack()
        } else {
            super.onBackPressed()
        }
    }

    private fun showProgressLottieDialog(context: Context) {
        alertDialog = LottieAlertDialog.Builder(context, DialogTypes.TYPE_LOADING)

            .setTitle("Loading...")
            .setDescription("Please...Wait...")
            .build()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}

