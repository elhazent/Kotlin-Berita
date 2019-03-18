package com.elhazent.picodiploma.kotlinberita.API

import com.google.gson.annotations.SerializedName

class ResponseBerita {

    @SerializedName("berita")
    val berita: ArrayList<BeritaItem>? = null

    @SerializedName("status")
    val status: Boolean = false

    override fun toString(): String {
        return "ResponseBerita(" +
                "berita =  '" + berita + '\''.toString() +
                ",status = '" + status + '\''.toString() +
                ")"
    }
}