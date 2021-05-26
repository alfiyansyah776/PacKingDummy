package soulever.project.entity

import com.google.gson.annotations.SerializedName

data class Recommended
    (
    @SerializedName("kemasan") val Kemasan: String,
    @SerializedName("jenis") val Jenis : String,
    @SerializedName("bahan") val Bahan : String,
    @SerializedName("Warna") val Warna : String,
    @SerializedName("harga") val Harga : String
)
