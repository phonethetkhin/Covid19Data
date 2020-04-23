package com.example.covid19data.ui

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19data.R
import com.example.covid19data.utils.getStringExtra

class NewsDetailActivity : AppCompatActivity() {
    lateinit var wbvNews: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        wbvNews = findViewById<WebView>(R.id.wbvNews)

        val url = getStringExtra(this, "url")
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
}

