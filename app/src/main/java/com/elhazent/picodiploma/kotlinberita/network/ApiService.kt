package com.elhazent.picodiploma.kotlinberita.network

import com.elhazent.picodiploma.kotlinberita.API.ResponseBerita
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //@TIPEMETHOD("END_POINT")
    @GET("tampil_berita.php")
    fun request_show_all_berita(): Call<ResponseBerita>

}