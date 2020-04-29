package com.example.covid19data.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.models.CountryDetailModel
import com.example.covid19data.ui.CountryDetailActivity
import com.squareup.picasso.Picasso
import java.util.*


class CountriesAdapter(var countriesList: List<CountryDetailModel>,val filterCountrylist:List<CountryDetailModel>,val flagList: List<String>) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>(),Filterable {
    private var valueFilter: ValueFilter? = null

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val crvCountriesList: CardView = v.findViewById(R.id.crvCountriesList)
        val imgCountryFlag: ImageView = v.findViewById(R.id.imgCountryFlag)
        val txtCountryName: TextView = v.findViewById(R.id.txtCountryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =

            LayoutInflater.from(parent.context).inflate(R.layout.countrieslistitem, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val space = if (countriesList[position].iso2.isNullOrBlank()) {

            "( " + ")"

        } else {
            "( ${countriesList[position].iso2} )"
        }
        holder.txtCountryName.text =
            countriesList[position].name + " " + space
        Picasso.get().load(flagList[position]).into(holder.imgCountryFlag)
        holder.crvCountriesList.setOnClickListener {

            val intent = Intent(it.context, CountryDetailActivity::class.java)
            intent.putExtra("name", countriesList[position].name)
            intent.putExtra("flag", flagList[position])
            it.context.startActivity(intent)
        }


    }
    @Suppress("UNCHECKED_CAST")
    inner class ValueFilter : Filter() {

        override fun performFiltering(constraint: CharSequence): FilterResults {
            val results = FilterResults()
            if (constraint.isNotEmpty()) {
                val filterList: MutableList<CountryDetailModel> =
                    ArrayList<CountryDetailModel>()
                for (i in filterCountrylist.indices) {
                    if (filterCountrylist[i].name
                            .toUpperCase(Locale.ROOT).contains(constraint.toString().toUpperCase(
                                Locale.ROOT
                            )
                            )
                    ) {
                        filterList.add(filterCountrylist[i])
                    }
                }
                results.count = filterList.size
                results.values = filterList
            } else {
                results.count = filterCountrylist.size
                results.values = filterCountrylist
            }
            return results
        }

        override fun publishResults(
            constraint: CharSequence,
            results: FilterResults
        ) {

            countriesList = results.values as List<CountryDetailModel>
            notifyDataSetChanged()
        }
    }

    override fun getFilter(): Filter {
        if (valueFilter == null) {
            valueFilter = ValueFilter()
        }
        return valueFilter as ValueFilter
    }


}