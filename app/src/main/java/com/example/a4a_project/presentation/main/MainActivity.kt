package com.example.a4a_project.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.a4a_project.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mainViewModel.text --> class var
        mainViewModel.text.observe(this, Observer {
            //main_text layout var
            value -> main_text.text = value
        })

        button.setOnClickListener {
            mainViewModel.onClickedIncrement()
        }

        button2.setOnClickListener {
            mainViewModel.onClickedEmail("Not Useful")
        }

        mainViewModel.number.observe(this, Observer{
            value -> button.text = value.toString()
        })

    }
}