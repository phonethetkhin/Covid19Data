package com.example.covid19data.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19data.interfaces.FragmentToActivity

import com.example.covid19data.R

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
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

}
