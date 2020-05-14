@file:Suppress("DEPRECATION")

package com.ptk.covid19data.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ptk.covid19data.R
import com.ptk.covid19data.interfaces.FragmentToActivity
import com.ptk.covid19data.utils.getStringPref
import com.ptk.covid19data.utils.getTimeZone
import com.ptk.covid19data.utils.isNetworkActive
import com.ptk.covid19data.utils.setToast
import com.ptk.covid19data.vModel.CountryDetailViewModel
import com.ptk.covid19data.vModel.SummaryViewModel
import kotlinx.android.synthetic.main.activity_country_detail.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.txtCountryName
import kotlinx.android.synthetic.main.fragment_home.view.txtDeaths
import kotlinx.android.synthetic.main.fragment_home.view.txtLastUpdated
import kotlinx.android.synthetic.main.fragment_home.view.txtRecovered
import kotlinx.android.synthetic.main.fragment_home.view.txtTotalCases

@SuppressLint("SimpleDateFormat")

class HomeFragment(private val activity: AppCompatActivity) : Fragment() {
    private lateinit var fragmentToActivity: FragmentToActivity
    fun setHomeFragmentToActivityCommunication(listener: FragmentToActivity) {

        this.fragmentToActivity = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener(activity.resources.getString(R.string.worldwide_title))
        fragmentToActivity.setCheckListener(R.id.nav_home)

        val v = inflater.inflate(R.layout.fragment_home, container, false)

        checkConnection(v)

        v.srlHome.setOnRefreshListener {
            v.srlHome.isRefreshing = true
            checkConnection(v)
            v.srlHome.isRefreshing = false

        }

        return v
    }

    private fun checkConnection(v: View) {
        if (isNetworkActive(activity)) {
            v.cslHome.visibility = View.VISIBLE
            v.noInternetLayout.visibility = View.GONE
            mainFunction(v)
        } else {
            v.cslHome.visibility = View.GONE
            v.noInternetLayout.visibility = View.VISIBLE
            setToast(
                activity,
                "Network is slow or cannot reach, Please check you connection and Swipe to Reload !!!",
                Toast.LENGTH_SHORT
            )
        }
    }

    private fun mainFunction(v: View) {
        val vModel = ViewModelProviders.of(activity).get(SummaryViewModel::class.java)
        vModel.getSummaryViewModel(activity)
        vModel.summaryLiveData.observe(activity, Observer {
            it?.let {
                v.txtWorldTotalCases.text = it.confirmedModel.totalCases.toString()
                v.txtWorldDeaths.text = it.deathsModel.totalDeaths.toString()
                v.txtWorldRecovered.text = it.recoveredModel.totalRecovered.toString()
                v.txtLastUpdated.text = getTimeZone((it.lastestUpdate))
            }
        })
        val value = getStringPref(activity, "countryname", "countryname", "Burma")
        v.txtCountryName.text = value


        val vCountryModel = ViewModelProviders.of(this).get(CountryDetailViewModel::class.java)
        vCountryModel.getCountryDetail(activity, value)
        vCountryModel.countryDetailLiveData.observe(activity, Observer {

            v.txtTotalCases.text = it.confirmedModel.totalCases.toString()
            v.txtRecovered.text = it.recoveredModel.totalRecovered.toString()
            v.txtDeaths.text = it.deathsModel.totalDeaths.toString()

        })
    }

}
