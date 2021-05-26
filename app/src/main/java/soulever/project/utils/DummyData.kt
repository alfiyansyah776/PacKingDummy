package soulever.project.utils

import android.util.Log
import com.google.type.LatLng
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soulever.project.R
import soulever.project.entity.Collections
import soulever.project.entity.Recommended
import soulever.project.entity.Tutorial


object DummyData {
    fun generateDummyTutorial() : List<Tutorial> {
        val tutorials = ArrayList<Tutorial>()

        tutorials.add(
            Tutorial("Cara masang solatip", R.drawable.image_artikel_1)
        )
        tutorials.add(
            Tutorial("Cara make gunting", R.drawable.image_artikel_1)
        )
        tutorials.add(
            Tutorial("Cara ngelipet kardus", R.drawable.image_artikel_1)
        )

        return tutorials

    }

    fun generateDummyCollection() : List<Collections>{
        val collections = ArrayList<Collections>()

        collections.add(
            Collections(
                "Ini Nama",
                "Kardus",
                "Pertama-tama pasang sabuk",
                R.drawable.contoh_collection
            )
        )
        collections.add(
            Collections(
                "Ini Nama",
                "Kardus",
                "Pertama-tama pasang sabuk",
                R.drawable.contoh_collection
            )
        )
        collections.add(
            Collections(
                "Ini Nama",
                "Kardus",
                "Pertama-tama pasang sabuk",
                R.drawable.contoh_collection
            )
        )
        return collections
    }

    fun generateDummyRecommended() : List<Recommended>
    {
        val latLngData = ArrayList<Recommended>()
        val postServices = DataRepository.create()
        postServices.getPosts().enqueue(object : Callback<ArrayList<Recommended>> {
            override fun onResponse(
                call: Call<ArrayList<Recommended>>,
                response: Response<ArrayList<Recommended>>
            ) {
                val list = ArrayList<LatLng>()
                for (i in 0 until latLngData.size()) {
                    val lat: Double = latLngData.get(i).
                    val lng: Double = latLngData.get(i).getLng()
                    list.add(LatLng(lat, lng))
                }

            }

            override fun onFailure(call: Call<ArrayList<Recommended>>, t: Throwable) {

            }
        }
        )
        Log.d("tag", "isi ${recommendeds.toString()}")
        return recommendeds
    }
}