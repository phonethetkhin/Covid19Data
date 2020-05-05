@file:Suppress("DEPRECATION")

package com.example.covid19data.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.adapters.CountriesAdapter
import com.example.covid19data.interfaces.FragmentToActivity
import com.example.covid19data.models.CountryModel
import com.example.covid19data.utils.setLayoutManagerRecyclerview
import com.example.covid19data.vModel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_countries.view.*

@Suppress("DEPRECATION")
class CountriesFragment : Fragment() {
    private lateinit var fragmentToActivity: FragmentToActivity
    lateinit var adapter: CountriesAdapter
    var filterList: List<CountryModel> =
        arrayListOf()


    fun setCountryFragmentToActivityCommunication(listener: FragmentToActivity) {
        this.fragmentToActivity = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToActivity.setTitleListener("By Countries")
        fragmentToActivity.setCheckListener(R.id.nav_countries)


        val v = inflater.inflate(R.layout.fragment_countries, container, false)
        mainFunction(v)

        return v
    }

    private fun mainFunction(v: View) {
        setLayoutManagerRecyclerview(
            activity!!, v.rcvCountriesList, RecyclerView.VERTICAL, true,
            reverseLayout = false
        )
        val vModel = ViewModelProviders.of(activity!!).get(CountryViewModel::class.java)
        vModel.getCountryDBLiveData()

        vModel.countryDBLiveData.observe(activity!!, Observer {
            it?.let {
                filterList = it.countriesList
                adapter = CountriesAdapter(filterList, filterList)

                v.rcvCountriesList.adapter = adapter
            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        activity!!.menuInflater.inflate(R.menu.homemenu, menu)
        val searchView =
            menu.findItem(R.id.mimSearch).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                fragmentToActivity.searchViewClickListener(true)
                adapter.filter.filter(newText)
                return false
            }
        })


    }


}
