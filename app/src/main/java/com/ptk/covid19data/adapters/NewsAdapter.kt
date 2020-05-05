package com.ptk.covid19data.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ptk.covid19data.R
import com.ptk.covid19data.models.NewsDetailModel
import com.ptk.covid19data.ui.NewsDetailActivity
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList: List<NewsDetailModel>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val crvNews: CardView = v.findViewById(R.id.crvNews)
        val txtTitle: TextView = v.findViewById(R.id.txtTitle)
        val txtSourceName: TextView = v.findViewById(R.id.txtSourceName)
        val txtAuthorName: TextView = v.findViewById(R.id.txtAuthor)
        val imgNewsPhoto: ImageView = v.findViewById(R.id.imgNewsPhoto)
        val txtContent: TextView = v.findViewById(R.id.txtContent)
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
        holder.crvNews.setOnClickListener {

            val intent = Intent(it.context, NewsDetailActivity::class.java)
            intent.putExtra("url", newsList[position].URL)
            it.context.startActivity(intent)


        }


    }


}
