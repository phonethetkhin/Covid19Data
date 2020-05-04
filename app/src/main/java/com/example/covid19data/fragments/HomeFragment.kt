@file:Suppress("DEPRECATION")

package com.example.covid19data.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.utils.getTimeZone
import com.example.covid19data.utils.isNetworkActive
import com.example.covid19data.utils.setToast
import com.example.covid19data.vModel.SummaryViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

@SuppressLint("SimpleDateFormat")

class HomeFragment(val activity: AppCompatActivity) : Fragment() {
    private lateinit var fragmentToActivity: FragmentToActivity
    fun setHomeFragmentToActivityCommunication(listener: FragmentToActivity) {

        this.fragmentToActivity = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener("WorldWide")
        fragmentToActivity.setCheckListener(R.id.nav_home)

        val v = inflater.inflate(R.layout.fragment_home, container, false)

        checkConnection(activity,v)

        return v
    }
    fun checkConnection(activity: AppCompatActivity, v:View)
    {
        if(isNetworkActive(activity))
        {
            mainFunction(v)
        }
        else
        {
            setToast(activity,"No Network",Toast.LENGTH_SHORT)
        }
    }
    fun mainFunction(v :View)
    {
        val vModel = ViewModelProviders.of(activity!!).get(SummaryViewModel::class.java)
        vModel.getSummaryViewModel()
        vModel.summaryLiveData.observe(activity!!, Observer {
            it?.let {
                v.txtTotalCases.text = it.confirmedModel.totalCases.toString()
                v.txtDeaths.text = it.deathsModel.totalDeaths.toString()
                v.txtRecovered.text = it.recoveredModel.totalRecovered.toString()
                v.txtLastUpdated.text = getTimeZone((it.lastestUpdate))
            }
        })
    }

}
