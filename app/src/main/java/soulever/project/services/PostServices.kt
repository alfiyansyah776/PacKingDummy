package soulever.project.services

import retrofit2.Call
import retrofit2.http.GET
import soulever.project.entity.Recommended

interface PostServices {
    @GET("data.json")
    fun getPosts(): Call<ArrayList<Recommended>>
}