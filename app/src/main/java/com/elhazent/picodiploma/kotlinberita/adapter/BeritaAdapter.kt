package com.elhazent.picodiploma.kotlinberita.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elhazent.picodiploma.kotlinberita.API.BeritaItem
import com.elhazent.picodiploma.kotlinberita.R
import com.elhazent.picodiploma.kotlinberita.activity.DetailActivity
import com.squareup.picasso.Picasso

class BeritaAdapter (var context: Context,var items: ArrayList<BeritaItem>?)
    : RecyclerView.Adapter<ViewHolder>() {

    var API_URL = "http://172.20.30.7/portal_berita-master/"
    const val TITLE_KEY = "JDL"
    const val DATE_KEY = "TGL"
    const val AUTHOR_KEY = "PNS"
    const val FOTO_KEY = "FTO"
    const val BODY_KEY = "ISI"
        
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var view:View = LayoutInflater.from(p0.context).inflate(R.layout.berita_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judul.setText(items!!.get(position).judulBerita)
        holder.tanggal.setText(items!!.get(position).tanggalPost)
        holder.penulis.setText(items!!.get(position).penulis)

        val urlImg:String = API_URL + "images/" + items!!.get(position).foto

        Picasso.with(context).load(urlImg).into(holder.img)

        holder.itemView.setOnClickListener {
            // Mulai activity detail
            val intent = Intent(context, DetailActivity::class.java)
            // Sisipkan data ke intent
            intent.putExtra(TITLE_KEY, items!!.get(position).judulBerita)
            intent.putExtra(DATE_KEY, items!!.get(position).tanggalPost)
            intent.putExtra(AUTHOR_KEY, items!!.get(position).penulis)
            intent.putExtra(FOTO_KEY, urlImg)
            intent.putExtra(BODY_KEY, items!!.get(position).isiBerita)

            context.startActivity(intent)
        }

    }

}
