package com.example.covid19data.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.fragments.CountriesFragment
import com.example.covid19data.fragments.HomeFragment
import com.example.covid19data.fragments.NewsFragment
import com.example.covid19data.models.CountryDetailModel
import com.example.covid19data.models.CountryModel

fun fragmentAttach(
    fragment: Fragment,
    fragmentActivityCommunication: FragmentToActivity
) {
    when (fragment) {

        is HomeFragment -> {
            fragment.setonFragmentActivitycommunication(fragmentActivityCommunication)

        }
        is CountriesFragment ->
        {
            fragment.setfragmenttoactivity(fragmentActivityCommunication)
        }
        is NewsFragment ->
        {
            fragment.setfragmenttoactivity(fragmentActivityCommunication)
        }

    }
}

fun setFragment(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    backstack: Boolean,
    container: Int
) {

    val transaction: FragmentTransaction =
        fragmentManager.beginTransaction()

    if (!backstack) {
        transaction.replace(container, fragment).commit()
    } else {
        transaction.replace(container, fragment).addToBackStack(null).commit()
    }
}

fun setFragmentByBundle(

    fragmentManager: FragmentManager,
    fragment: Fragment,
    backstack: Boolean,
    container: Int,
    bundle: Bundle

) {

    val transaction: FragmentTransaction =

        fragmentManager.beginTransaction()

    fragment.arguments = bundle



    if (!backstack) {

        transaction.replace(container, fragment).commit()

    } else {

        transaction.replace(container, fragment).addToBackStack(null).commit()

    }





}
