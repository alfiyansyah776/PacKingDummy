package soulever.project.db

import android.provider.BaseColumns

internal class DatabaseContract {
    internal class TopCollectionColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "topcollection"
            const val _ID = "_id"
            const val KEMASAN = "kemasan"
            const val JENIS = "jenis"
            const val BAHAN = "bahan"
            const val WARNA = "warna"
            const val HARGA = "harga"
            const val IMAGE = "image"
        }
    }
}