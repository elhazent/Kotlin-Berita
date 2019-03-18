package com.elhazent.picodiploma.kotlinberita.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.elhazent.picodiploma.kotlinberita.R

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var judul= view.findViewById<TextView>(R.id.tvJudulBerita)
    var tanggal = view.findViewById<TextView>(R.id.tvTglTerbit)
    var penulis = view.findViewById<TextView>(R.id.tvPenulis)
    var img = view.findViewById<ImageView>(R.id.ivGambar)
}