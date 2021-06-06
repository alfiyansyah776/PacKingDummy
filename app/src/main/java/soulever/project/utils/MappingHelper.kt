package soulever.project.utils

import android.database.Cursor
import soulever.project.db.DatabaseContract
import soulever.project.entity.Recommended

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): List<Recommended> {
        val notesList = ArrayList<Recommended>()
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns._ID))
                val kemasan =
                    getString(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns.KEMASAN))
                val jenis =
                    getString(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns.JENIS))
                val bahan =
                    getString(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns.BAHAN))
                val warna =
                    getString(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns.WARNA))
                val harga =
                    getString(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns.HARGA))
                val gambar =
                    getString(getColumnIndexOrThrow(DatabaseContract.TopCollectionColumns.IMAGE))
                notesList.add(Recommended(kemasan, jenis, bahan, warna, harga, gambar))
            }
        }
        return notesList
    }
}