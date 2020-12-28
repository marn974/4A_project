package com.example.a4a_project.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4a_project.ApiInterface
import com.example.a4a_project.R
import com.example.a4a_project.data.Ghibli
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DataGhibliActivity : AppCompatActivity() {
    var list : List<Ghibli>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_ghibli_activity)

        list = apiCall()


    }

    fun apiCall() : List<Ghibli>?{
        val baseUrl : String = "https://ghibliapi.herokuapp.com/"
        var films : List<Ghibli>? = null

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        val call: Call<List<Ghibli>> = apiInterface.getGhibliResponse()

        call.enqueue(object : Callback<List<Ghibli>> {

            override fun onFailure(call: Call<List<Ghibli>>, t: Throwable) {
                Log.i("API REST", "Failed Api call ")

            }

            override fun onResponse(call: Call<List<Ghibli>>, response: Response<List<Ghibli>>) {
                val res = response.body()
                if (response.code() == 200 && res != null) {
                    films = res
                    Log.i("API REST", "Success Api call. Films is not empty ")
                    showList(films!!)
                } else {
                    //DO SOMETHING
                    Log.i("API REST", "Success Api call.Films is empty ")
                }

            }
        })

        return films

    }
    fun showList(list : List<Ghibli>){
        Log.i("SHOW LIST ", "got called")
        var recyclerView : RecyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.setHasFixedSize(true)

        var layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        var adapter = ListAdapter(list)
        recyclerView.adapter = adapter

    }
}

