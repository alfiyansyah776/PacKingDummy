package soulever.project.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soulever.project.services.PostServices

object DataRepository {
    fun create(): PostServices {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://storage.googleapis.com/packing-bucket/rekomendasi-donat/")
            .build()
        return retrofit.create(PostServices::class.java)
    }
}