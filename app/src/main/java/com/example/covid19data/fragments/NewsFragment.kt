package com.example.covid19data.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.adapters.NewsAdapter
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.vModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.view.*


class NewsFragment : Fragment() {
    lateinit var fragmentToActivity: FragmentToActivity
    fun setfragmenttoactivity(listener: FragmentToActivity) {
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
        v.rcvNews.layoutManager = LinearLayoutManager(activity!!,RecyclerView.VERTICAL,false)
        v.rcvNews.setHasFixedSize(true)

        val vModel = ViewModelProviders.of(activity!!).get(NewsViewModel::class.java)

        vModel.getNewsLiveDataVM()
        vModel.newsLiveData.observe(activity!!, Observer {
            it?.let {
                v.rcvNews.adapter = NewsAdapter(it.articles)
            }
        })



        return v

    }


}

