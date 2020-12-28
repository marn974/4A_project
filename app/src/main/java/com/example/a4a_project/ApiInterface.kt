package com.example.a4a_project

import com.example.a4a_project.data.Ghibli
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("films")
    fun getGhibliResponse(): Call<List<Ghibli>>
}