package com.example.a4a_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.text.observe(this, Observer {
            value -> main_text.text = value
        })

        button.setOnClickListener {
            mainViewModel.onClickedIncrement()
        }

        mainViewModel.number.observe(this, Observer{
            value -> button.text = value.toString()
        })

    }
}