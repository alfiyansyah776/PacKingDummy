package soulever.project.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import soulever.project.entity.Recommended

interface PostServices {
    @GET("{id}/data.json")
    fun getPosts(@Path("id") id: String): Call<List<Recommended>>
}