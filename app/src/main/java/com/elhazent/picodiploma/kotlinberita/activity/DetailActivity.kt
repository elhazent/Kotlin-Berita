package com.elhazent.picodiploma.kotlinberita.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.elhazent.picodiploma.kotlinberita.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.berita_item.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    val JDL:String = "JDL"
    val TGL:String = "TGL"
    val PNS:String = "PNS"
    val ISI:String = "ISI"
    val FTO:String = "FTO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        tampilBerita()

    }

    private fun tampilBerita() {
        val judul_berita = intent.getStringExtra(JDL)
        val tangal_berita = intent.getStringExtra(TGL)
        val penulis_berita = intent.getStringExtra(PNS)
        val isi_berita = intent.getStringExtra(ISI)
        val foto_berita = intent.getStringExtra(FTO)

        val terbit = findViewById<TextView>(R.id.tvTglTerbit)
        val penulis = findViewById<TextView>(R.id.tvPenulis)

        penulis.setText("Oleh : $penulis_berita")
        terbit.setText(tangal_berita)

        Picasso.with(this).load(foto_berita).into(ivGambarBerita)
        wvContentBerita.getSettings().setJavaScriptEnabled(true)
        wvContentBerita.loadData(isi_berita, "text/html; charset=utf-8", "UTF-8")
    }

}
