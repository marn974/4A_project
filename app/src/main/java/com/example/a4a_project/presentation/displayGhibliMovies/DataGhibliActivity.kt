package com.example.a4a_project.presentation.displayGhibliMovies

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4a_project.R
import org.koin.android.ext.android.inject


class DataGhibliActivity : AppCompatActivity() {
    val dataGhibliViewModel : DataGhibliViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_ghibli_activity)

        dataGhibliViewModel.onCreate(this)
        fun showList(){
            var recyclerView : RecyclerView = findViewById(R.id.my_recycler_view)
            var layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = layoutManager
            dataGhibliViewModel.showList(dataGhibliViewModel.films.value!!, recyclerView, layoutManager)


        }
        dataGhibliViewModel.dataSetStatus.observe(this, Observer {
            when (it) {
                is DataSetNotEmpty ->{
                    showList()
                    Log.i("Observe dataSetStatus", "Not Empty " + dataGhibliViewModel.films.value!![1].director)
                }
                DataSetEmpty->{
                    Log.i("Observe dataSetStatus", "empty -> api call")
                    dataGhibliViewModel.apiCall()
                }
            }
        })



        dataGhibliViewModel.apiCallResultLiveData.observe(this, Observer {
            when (it) {
                is ApiCallFailed ->{
                    Log.i("OBSERVER", "Failed")
                    Toast.makeText(this, "Unable to load the api. Check your internet connection?", Toast.LENGTH_LONG).show()
                }
                ApiCallSuccess ->{
                    Log.i("OBSERVER", "Success")
                    dataGhibliViewModel.saveList(dataGhibliViewModel.films.value!!, applicationContext)
                    showList()
                }
            }

        })


    }
}












