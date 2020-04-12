package com.example.covid19data.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.models.CountryDetailModel

class CountriesAdapter(
    private val countrieslist: List<CountryDetailModel>,
    val flaglist: List<Drawable>?
) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgCountryFlag: ImageView = v.findViewById<ImageView>(R.id.imgCountryFlag)
        val txtCountryName: TextView = v.findViewById<TextView>(R.id.txtCountryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.countrieslistitem, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return countrieslist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var space: String? = null
        space = if (countrieslist[position].iso2.isNullOrBlank()) {

            "( " + ")"

        } else {
            "( " + countrieslist[position].iso2 + " )"
        }


        holder.txtCountryName.text =
            countrieslist[position].name + " " + space

        holder.imgCountryFlag.setImageDrawable(flaglist?.get(position))

    }
}