package com.example.covid19data.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.covid19data.R
import com.example.covid19data.interfaces.FragmentToActivity


class NewsFragment : Fragment() {
    lateinit var webview : WebView
    lateinit var fragmentToActivity: FragmentToActivity
    fun setfragmenttoactivity(listener : FragmentToActivity)
    {
        this.fragmentToActivity = listener
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener("News")
        fragmentToActivity.setCheckListener(R.id.nav_news)
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_news, container, false)
         webview = v.findViewById<WebView>(R.id.wbvNews)

        val url: String? = arguments!!.getString("url")


        webview.webViewClient = MyWebViewClient()


        webview.settings.javaScriptEnabled = true
        webview.loadUrl(url) // load the url on the web view

        return v

    }


    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
            view.loadUrl(url) // load the url
            return true
        }
    }

    fun canGoBack(): Boolean {
        return webview.canGoBack()
    }

    fun goBack() {
        webview.goBack()
    }


}

