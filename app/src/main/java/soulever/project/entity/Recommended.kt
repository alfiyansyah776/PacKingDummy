package soulever.project.entity

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recommended
    (
    @SerializedName("produk") val Kemasan: String,
    @SerializedName("jenis") val Jenis : String,
    @SerializedName("bahan") val Bahan : String,
    @SerializedName("warna") val Warna : String,
    @SerializedName("harga") val Harga : String,
    @SerializedName("url") val Image : String
) : Parcelable
