package com.example.covid19data.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19data.R
import com.example.covid19data.utils.getStringExtra
import com.example.covid19data.utils.*
import com.labters.lottiealertdialoglibrary.DialogTypes
import com.labters.lottiealertdialoglibrary.LottieAlertDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewsDetailActivity : AppCompatActivity() {
    lateinit var alertDialog:LottieAlertDialog

    lateinit var wbvNews: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onStart() {
        super.onStart()
        showProgressLottieDialog(this)
        GlobalScope.launch {
            delay(5000L)
            alertDialog.dismiss()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        wbvNews = findViewById(R.id.wbvNews)

        val url = getStringExtra(this, "url")
        wbvNews.settings.javaScriptEnabled = true;

        wbvNews.webViewClient = MyWebViewClient()


        wbvNews.loadUrl(url)

    }

    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
            view.loadUrl(url)
            return true
        }
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

