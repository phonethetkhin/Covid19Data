package com.example.covid19data.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.interfaces.FragmentToActivity

import com.example.covid19data.R
import com.example.covid19data.vModel.SummaryViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.StringBuilder

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
   lateinit var fragmentToActivity: FragmentToActivity
fun setonFragmentActivitycommunication(listener: FragmentToActivity) {

this.fragmentToActivity= listener
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener("WorldWide")
        fragmentToActivity.setCheckListener(R.id.nav_home)
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_home, container, false)
        val vModel = ViewModelProviders.of(activity!!).get(SummaryViewModel::class.java)
        vModel.getSummaryViewModel()
            vModel.summaryLiveData.observe(activity!!, Observer {
                it?.let {
                    val global = it.globalModel
                    val countires = it.countryModellist
                    val date = it.date

                    val stringBuilder = StringBuilder(date)
                     val output=   stringBuilder.replace(10,11,", ").replace(20, 21," ")


                    v.txtTotalCases.text = global.totalConfirmed.toString()
                    v.txtDeaths.text = global.totalDeaths.toString()
                    v.txtRecovered.text = global.totalRecovered.toString()

                    v. txtLastUpdated.text = output
                }
            })
        return v
    }



}
