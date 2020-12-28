package com.example.a4a_project.presentation.list

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4a_project.R
import com.example.a4a_project.domain.entity.Ghibli
import org.koin.android.ext.android.inject


class DataGhibliActivity : AppCompatActivity() {
    val dataGhibliViewModel : DataGhibliViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_ghibli_activity)

        dataGhibliViewModel.apiCall()

        fun showList(list : List<Ghibli>){

            Log.i("SHOW LIST ", "got called")
            var recyclerView : RecyclerView = findViewById(R.id.my_recycler_view)
            recyclerView.setHasFixedSize(true)

            var layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager

            var adapter = ListAdapter(list)
            recyclerView.adapter = adapter

        }

        dataGhibliViewModel.apiCallResultLiveData.observe(this, Observer {
            when (it) {
                is ApiCallFailed ->{
                    Log.i("OBSERVER", "Failed")
                    Toast.makeText(this, "Unable to load the api. Check your internet connection?", Toast.LENGTH_LONG).show()
                }
                ApiCallSuccess ->{
                    Log.i("OBSERVER", "Success")
                    showList(dataGhibliViewModel.films.value!!)
                }
            }

        })


    }
}












