package com.elhazent.picodiploma.kotlinberita

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.elhazent.picodiploma.kotlinberita.API.BeritaItem
import com.elhazent.picodiploma.kotlinberita.API.ResponseBerita
import com.elhazent.picodiploma.kotlinberita.adapter.BeritaAdapter
import com.elhazent.picodiploma.kotlinberita.network.InitRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        sendRequestBerita()
        recyclerView.setHasFixedSize(true)
    }

    private fun sendRequestBerita() {
        InitRetrofit.getInstance.request_show_all_berita().enqueue(object : Callback<ResponseBerita> {
            override fun onResponse(call: Call<ResponseBerita>, response: Response<ResponseBerita>) {

                val berita_item = response.body()!!.berita

                if (response.isSuccessful){
                    Log.d("Response","Success")
                    val list_berita = response.body()!!.berita
                    val status = response.body()!!.status

                    if (status){
                        val adapter = BeritaAdapter(this@MainActivity, list_berita)
                        recyler.adapter = adapter
                    } else{
                        Toast.makeText(this@MainActivity, "tidak ada berita untuk hari ini", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBerita>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}

