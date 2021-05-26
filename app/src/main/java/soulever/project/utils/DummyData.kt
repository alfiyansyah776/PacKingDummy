package soulever.project.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
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

    fun generateDummyRecommended() : MutableLiveData<List<Recommended>>
    {
        val serviceSetterGetter = MutableLiveData<List<Recommended>>()
        val postServices = DataRepository.create()
        postServices.getPosts().enqueue(object : Callback<List<Recommended>> {
            override fun onResponse(
                call: Call<List<Recommended>>,
                response: Response<List<Recommended>>
            ) {
                val data = response.body()
                serviceSetterGetter.value = data!!
            }

            override fun onFailure(call: Call<List<Recommended>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        }
        )

        return serviceSetterGetter
    }
}