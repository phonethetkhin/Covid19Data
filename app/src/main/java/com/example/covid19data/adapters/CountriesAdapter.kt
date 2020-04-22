package com.example.covid19data.adapters

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.models.CountryDetailModel
import com.example.covid19data.ui.CountryDetailActivity
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream


class CountriesAdapter(
    private val countrieslist: List<CountryDetailModel>,
    val flaglist: List<String>
) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val crvCountrieslist = v.findViewById<CardView>(R.id.crvCountriesList)
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

        val space: String?
        space = if (countrieslist[position].iso2.isNullOrBlank()) {

            "( " + ")"

        } else {
            "( " + countrieslist[position].iso2 + " )"
        }


        holder.txtCountryName.text =
            countrieslist[position].name + " " + space
        Picasso.get().load(flaglist!![position]).into(holder.imgCountryFlag)
       /* holder.crvCountrieslist.setOnClickListener {


            val bitmap = (flaglist?.get(position) as BitmapDrawable).bitmap

            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
            val b: ByteArray = baos.toByteArray()


            val intent = Intent(it.context, CountryDetailActivity::class.java)
            intent.putExtra("name", countrieslist[position].name)
            intent.putExtra("flag",b)

            it.context.startActivity(intent)


        }*/

    }
}