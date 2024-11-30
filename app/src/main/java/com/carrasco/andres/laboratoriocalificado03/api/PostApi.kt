package com.carrasco.andres.laboratoriocalificado03.api

import com.carrasco.andres.laboratoriocalificado03.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}