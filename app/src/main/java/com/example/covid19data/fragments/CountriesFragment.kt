package com.example.covid19data.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.interfaces.FragmentToActivity

import com.example.covid19data.R
import com.example.covid19data.adapters.CountriesAdapter
import com.example.covid19data.utils.getFlags
import com.example.covid19data.vModel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_countries.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class CountriesFragment : Fragment() {
lateinit var fragmentToActivity: FragmentToActivity
    fun setfragmenttoactivity(listener : FragmentToActivity)
    {
        this.fragmentToActivity = listener
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener("By Countries")
        fragmentToActivity.setCheckListener(R.id.nav_countries)

        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_countries, container, false)
            v.rcvCountriesList.layoutManager = LinearLayoutManager(activity!!,RecyclerView.VERTICAL,false)
        v.rcvCountriesList.setHasFixedSize(true)
        val vModel = ViewModelProviders.of(activity!!).get(CountryViewModel::class.java)
        vModel.getCountryDBLiveData()

val flags = getFlags(activity!!.applicationContext)
        vModel.countryDBLiveData.observe(activity!!, Observer {
            it?.let {
                v.rcvCountriesList.adapter = CountriesAdapter(it.countrieslist, flags)
            }
        })

        return  v
    }

}
