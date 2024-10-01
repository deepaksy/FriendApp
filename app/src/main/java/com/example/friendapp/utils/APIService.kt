package com.example.friendapp.utils

import android.util.Log
import com.example.friendapp.api.MyApi
import com.example.friendapp.models.Comments
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getAllComments() {
    val api = Retrofit.Builder()
        .baseUrl("https://192.168.1.203")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MyApi::class.java)

    api.getComments().enqueue(object : Callback<List<Comments>> {
        override fun onResponse(p0: Call<List<Comments>>, p1: Response<List<Comments>>) {
            if(p1.isSuccessful) {
                p1.body()?.let {
                    for (comment in  it) {
                        Log.i("TAG", comment.name)
                    }
                }
            }
        }

        override fun onFailure(p0: Call<List<Comments>>, p1: Throwable) {
            Log.i("TAG", "onFaliure: ${p1.message}")
        }

    })
}