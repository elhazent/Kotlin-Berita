package com.elhazent.picodiploma.kotlinberita.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InitRetrofit {

    var API_URL = "http://172.20.30.7/portal_berita-master/tampil_berita.php/"

    fun setInit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val getInstance: ApiService
        get() =  setInit().create(ApiService::class.java)

}