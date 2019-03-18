package com.elhazent.picodiploma.kotlinberita.API

import com.google.gson.annotations.SerializedName

data class BeritaItem (
    @SerializedName("penulis")
    val penulis:String,
    @SerializedName("foto")
    val foto:String,
    @SerializedName("id")
    val id:String,
    @SerializedName("judul_berita")
    val judulBerita:String,
    @SerializedName("tanggal_posting")
    val tanggalPost:String,
    @SerializedName("isi_berita")
    val isiBerita:String)