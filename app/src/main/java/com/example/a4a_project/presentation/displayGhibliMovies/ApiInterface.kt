package com.example.a4a_project.presentation.displayGhibliMovies

import com.example.a4a_project.domain.entity.Ghibli
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("films")
    fun getGhibliResponse(): Call<List<Ghibli>>
}
