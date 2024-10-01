package com.example.friendapp.api

import com.example.friendapp.models.Comments
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("comments")
    fun getComments(): Call<List<Comments>>
}