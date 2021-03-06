@file:Suppress("DEPRECATION")

package com.ptk.covid19data.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.ptk.covid19data.R
import com.ptk.covid19data.adapters.NewsAdapter
import com.ptk.covid19data.interfaces.FragmentToActivity
import com.ptk.covid19data.utils.isNetworkActive
import com.ptk.covid19data.utils.setLayoutManagerRecyclerview
import com.ptk.covid19data.utils.setToast
import com.ptk.covid19data.vModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.view.*


class NewsFragment(private val activity: AppCompatActivity) : Fragment() {
    private lateinit var fragmentToActivity: FragmentToActivity
    fun setNewsFragmentToActivityCommunication(listener: FragmentToActivity) {
        this.fragmentToActivity = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener(activity.resources.getString(R.string.latestnews_title))
        fragmentToActivity.setCheckListener(R.id.nav_news)


        val v = inflater.inflate(R.layout.fragment_news, container, false)
        checkConnection(v)
        v.srlNews.setOnRefreshListener {
            v.srlNews.isRefreshing = true
            checkConnection(v)
            v.srlNews.isRefreshing = false
        }
        return v
    }

    private fun checkConnection(v: View) {
        if (isNetworkActive(activity)) {
            v.rcvNews.visibility = View.VISIBLE
            v.noInternetLayout.visibility = View.GONE
            mainFunction(v)
        } else {
            v.rcvNews.visibility = View.GONE
            v.noInternetLayout.visibility = View.VISIBLE

            setToast(
                activity,
                "Network is slow or cannot reach, Please check you connection and Swipe to Reload !!!",
                Toast.LENGTH_SHORT
            )

        }
    }

    private fun mainFunction(v: View) {
        setLayoutManagerRecyclerview(
            activity, v.rcvNews, RecyclerView.VERTICAL, true,
            reverseLayout = false
        )
        val vModel = ViewModelProviders.of(activity).get(NewsViewModel::class.java)

        vModel.getNewsLiveDataVM(activity)
        vModel.newsLiveData.observe(activity, Observer {
            it?.let {
                v.rcvNews.adapter = NewsAdapter(it.articles)
            }
        })

    }
}

