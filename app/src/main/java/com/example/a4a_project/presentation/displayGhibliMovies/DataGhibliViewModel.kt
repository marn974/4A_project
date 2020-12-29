package com.example.a4a_project.presentation.displayGhibliMovies

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4a_project.domain.entity.Ghibli
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.dsl.koinApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DataGhibliViewModel : ViewModel(){
    val films : MutableLiveData<List<Ghibli>> = MutableLiveData()
    val apiCallResultLiveData : MutableLiveData<ApiCallStatus> = MutableLiveData()
    val dataSetStatus : MutableLiveData<DataSetStatus> = MutableLiveData()


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
                    Log.i("API REST", "Success Api call. Films is not empty ")
                } else {

                    apiCallResultLiveData.value = ApiCallFailed
                    Log.i("API REST", "Success Api call.Films is empty ")
                }


            }
        })


    }
    fun showList(list : List<Ghibli>, recyclerView: RecyclerView, layoutManager: LinearLayoutManager){

        viewModelScope.launch(Dispatchers.IO){
            Log.i("SHOW LIST VIEWMODEL", "got called")

            var adapter = ListAdapter(list)
            recyclerView.adapter = adapter
        }


    }

    fun onCreate(context: Context){
        films.value = getDataFromCache(context)
        val DataSetStatus = if(films.value == null){
            Log.i("On Create", "data set empty ")
            DataSetEmpty
        }
        else {
            Log.i("On Create", "data set not empty ")
            DataSetNotEmpty

        }

        dataSetStatus.value = DataSetStatus

    }


    fun saveList(list: List<Ghibli>, context: Context) {
        val gson : Gson = GsonBuilder().setLenient().create()
        val json: String = gson.toJson(list)

        val sharedPreference =  context.getSharedPreferences("listGhibliMovies",Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("listGhibliMovies",json)
        Log.i("SHARED: ", "in savelist()")
        editor.commit()

    }

    fun getDataFromCache(context: Context): List<Ghibli>? {

        val gson : Gson= Gson()
        val list : List<Ghibli>
        val sharedPreference =  context.getSharedPreferences("listGhibliMovies",Context.MODE_PRIVATE)
        val json = sharedPreference.getString("listGhibliMovies",null)
        val type = object : TypeToken<List<Ghibli>>(){}.type//converting the json to list
        if (json != null){
            list = gson.fromJson(json,type)
            Log.i("SHARED From cache : ", " " + list.get(1).director)
            return list
        }

        Log.i("SHARED From cache : ", "json is null")
        return null




    }


}