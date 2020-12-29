package com.example.a4a_project.presentation.displayMovieInformation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4a_project.R
import com.example.a4a_project.presentation.displayGhibliMovies.DataGhibliViewModel
import org.koin.android.ext.android.inject

class GhibliMovieActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_ghibli_activity)

    }

}