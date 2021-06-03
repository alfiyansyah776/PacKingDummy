package soulever.project.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recommended(
    @SerializedName("produk") val kemasan: String? = null,
    @SerializedName("jenis") val jenis: String? = null,
    @SerializedName("bahan") val bahan: String? = null,
    @SerializedName("warna") val warna: String? = null,
    @SerializedName("harga") val harga: String? = null,
    @SerializedName("url") val image: String? = null
) : Parcelable
