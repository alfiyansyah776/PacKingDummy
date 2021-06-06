package soulever.project.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RumahKemasan(
    val Image: String,
    val Nama: String,
    val Alamat: String,
    val Kontak: String,
    val Tahun: String,
    val Kelembagaan: String,
    val DasarHukum: String
) : Parcelable