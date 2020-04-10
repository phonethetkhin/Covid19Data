package com.example.covid19data.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.covid19data.R
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.vModel.SummaryViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
   lateinit var fragmentToActivity: FragmentToActivity
fun setonFragmentActivitycommunication(listener: FragmentToActivity) {

this.fragmentToActivity= listener
}
    @SuppressLint("SimpleDateFormat")
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
                    val confirmed = it.confirmedModel.totalCases
                    val recovered = it.recoveredModel.totalRecovered
                    val deaths = it.deathsModel.totalDeaths

                    val date = (it.lastestUpdate)
                    val df =
                        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    df.timeZone = TimeZone.getTimeZone("PDT")

                    val formatted:Date? = df.parse(date)



                    val print =
                        SimpleDateFormat("MMM d, yyyy hh:mm:ss a z")
                    print.timeZone = TimeZone.getTimeZone("Asia/Rangoon")

                    val formatedDate = print.format(formatted)
                    val stringBuilder = StringBuilder(formatedDate)
                   val final =  stringBuilder.insert(24,"(").insert(35," ").insert(36, ")")




                    v.txtTotalCases.text = confirmed.toString()
                    v.txtDeaths.text = deaths.toString()
                    v.txtRecovered.text = recovered.toString()

                    v. txtLastUpdated.text = final.toString()
                }
            })
        return v
    }



}
