package com.example.a4a_project.presentation.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4a_project.R
import com.example.a4a_project.domain.entity.Ghibli
import com.example.a4a_project.presentation.main.CreateStatus
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataGhibliViewModel : ViewModel(){
    val films : MutableLiveData<List<Ghibli>> = MutableLiveData()
    val apiCallResultLiveData : MutableLiveData<ApiCallStatus> = MutableLiveData()


    fun apiCall(){
        val baseUrl : String = "https://ghibliapi.herokuapp.com/"

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
                apiCallResultLiveData.value = ApiCallFailed
                Log.i("API REST", "Failed Api call ")

            }

            override fun onResponse(call: Call<List<Ghibli>>, response: Response<List<Ghibli>>) {
                val res = response.body()
                if (response.code() == 200 && res != null) {
                    films.value = res
                    apiCallResultLiveData.value = ApiCallSuccess
                    Log.i("API REST", "Success Api call. Films is not empty " )
                } else {
                    //DO SOMETHING ApiCallFailed
                    apiCallResultLiveData.value = ApiCallFailed
                    Log.i("API REST", "Success Api call.Films is empty ")
                }


            }
        })


    }


}