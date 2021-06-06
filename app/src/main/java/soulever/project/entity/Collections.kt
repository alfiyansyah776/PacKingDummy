package soulever.project.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Collections(
    val nama: String,
    val bahan: String,
    val deskripsi: String,
    val image: String
) : Parcelable