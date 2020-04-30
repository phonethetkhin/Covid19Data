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
import com.example.covid19data.models.CountryDetailModel
import com.example.covid19data.models.CountryandFlagModel
import com.example.covid19data.utils.getBooleanPref
import com.example.covid19data.utils.setLayoutManagerRecyclerview
import com.example.covid19data.vModel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_countries.view.*
import java.util.ArrayList

class CountriesFragment : Fragment() {
    private lateinit var fragmentToActivity: FragmentToActivity
    lateinit var adapter: CountriesAdapter
    val filterList: MutableList<CountryandFlagModel> =
        arrayListOf<CountryandFlagModel>()


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
        setLayoutManagerRecyclerview(
            activity!!, v.rcvCountriesList, RecyclerView.VERTICAL, true,
            reverseLayout = false
        )
        val vModel = ViewModelProviders.of(activity!!).get(CountryViewModel::class.java)
        vModel.getCountryDBLiveData()

        vModel.countryDBLiveData.observe(activity!!, Observer {
            it?.let {
                for (i in it.countriesList.indices) {
                    val countryandFlagModel = CountryandFlagModel(it.countriesList[i].name,it.countriesList[i].iso2,it.flagList[i])
                    filterList.add(countryandFlagModel)
                }
                }
                adapter = CountriesAdapter(filterList,filterList)

                v.rcvCountriesList.adapter = adapter

        })

        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

            activity!!.menuInflater.inflate(R.menu.homemenu, menu)
            val searchView =
                menu.findItem(R.id.mimSearch).actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
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
