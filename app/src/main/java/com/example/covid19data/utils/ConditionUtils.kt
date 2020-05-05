@file:Suppress("DEPRECATION")

package com.example.covid19data.utils

import android.content.Context
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.covid19data.R
import com.example.covid19data.fragments.CountriesFragment
import com.example.covid19data.fragments.HomeFragment
import com.example.covid19data.fragments.NewsFragment
import com.example.covid19data.interfaces.FragmentToActivity

fun fragmentAttach(
    fragment: Fragment,
    fragmentActivityCommunication: FragmentToActivity
) {
    when (fragment) {

        is HomeFragment -> {

            fragment.setHomeFragmentToActivityCommunication(fragmentActivityCommunication)

        }
        is CountriesFragment -> {
            fragment.setCountryFragmentToActivityCommunication(fragmentActivityCommunication)
        }
        is NewsFragment -> {
            fragment.setNewsFragmentToActivityCommunication(fragmentActivityCommunication)
        }

    }
}

fun setFragment(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    backStack: Boolean,
    container: Int
) {

    val transaction: FragmentTransaction =
        fragmentManager.beginTransaction()

    if (!backStack) {
        transaction.replace(container, fragment).commit()
    } else {
        transaction.replace(container, fragment).addToBackStack(null).commit()
    }
}

fun setFragmentByBundle(

    fragmentManager: FragmentManager,
    fragment: Fragment,
    backStack: Boolean,
    container: Int,
    bundle: Bundle

) {

    val transaction: FragmentTransaction =

        fragmentManager.beginTransaction()

    fragment.arguments = bundle



    if (!backStack) {

        transaction.replace(container, fragment).commit()

    } else {

        transaction.replace(container, fragment).addToBackStack(null).commit()

    }

}

fun setCheckedtoSelectedColor(
    context: Context,
    theme: String?,
    green: ImageButton,
    blue: ImageButton,
    red: ImageButton
) {
    when (theme) {
        "Green" -> {
            blue.setImageDrawable(null)
            red.setImageDrawable(null)
            green.setImageDrawable(context.resources.getDrawable(R.drawable.ic_check_circle_black_24dp))
        }
        "Blue" -> {
            blue.setImageDrawable(null)
            red.setImageDrawable(null)
            blue.setImageDrawable(context.resources.getDrawable(R.drawable.ic_check_circle_black_24dp))
        }
        "Red" -> {
            blue.setImageDrawable(null)
            red.setImageDrawable(null)
            red.setImageDrawable(context.resources.getDrawable(R.drawable.ic_check_circle_black_24dp))
        }
        else -> {
            blue.setImageDrawable(null)
            red.setImageDrawable(null)
            red.setImageDrawable(context.resources.getDrawable(R.drawable.ic_check_circle_black_24dp))
        }

    }
}

