package soulever.project.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TopCollectionData(
    val Id : Int = 0,
    val Kemasan: String ="",
    val Jenis: String ="",
    val Bahan: String="",
    val Warna: String="",
    val Harga: String="",
    val Image: String =""
) : Parcelable
