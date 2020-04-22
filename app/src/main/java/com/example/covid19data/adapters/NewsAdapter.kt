package com.example.covid19data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19data.R
import com.example.covid19data.models.NewsDetailModel
import com.squareup.picasso.Picasso

class NewsAdapter(val newsList:List<NewsDetailModel>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val txtTitle = v.findViewById<TextView>(R.id.txtTitle)
        val txtSourceName = v.findViewById<TextView>(R.id.txtSourceName)
        val txtAuthorName = v.findViewById<TextView>(R.id.txtAuthor)
        val imgNewsPhoto = v.findViewById<ImageView>(R.id.imgNewsPhoto)
        val txtContent = v.findViewById<TextView>(R.id.txtContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.newslistitem, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = newsList[position].title
        holder.txtSourceName.text = newsList[position].source.sourceName
        holder.txtAuthorName.text = newsList[position].author
        Picasso.get().load(newsList[position].ImageURl).into(holder.imgNewsPhoto)
        holder.txtContent.text = newsList[position].content

    }
}