package com.example.covid19data.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.adapters.CountriesAdapter
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.utils.setLayoutManagerRecyclerview
import com.example.covid19data.vModel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_countries.view.*

class CountriesFragment : Fragment() {
    private lateinit var fragmentToActivity: FragmentToActivity
    fun setCountryFragmentToActivityCommunication(listener: FragmentToActivity) {
        this.fragmentToActivity = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener("By Countries")
        fragmentToActivity.setCheckListener(R.id.nav_countries)

        val v = inflater.inflate(R.layout.fragment_countries, container, false)
        setLayoutManagerRecyclerview(
            activity!!, v.rcvCountriesList, RecyclerView.VERTICAL, true,
            reverseLayout = false
        )
        val vModel = ViewModelProviders.of(activity!!).get(CountryViewModel::class.java)
        vModel.getCountryDBLiveData()

        vModel.countryDBLiveData.observe(activity!!, Observer {
            it?.let {
                v.rcvCountriesList.adapter = CountriesAdapter(it.countriesList, it.flagList)
            }
        })

        return v
    }


}
