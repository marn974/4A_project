package com.example.a4a_project.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.a4a_project.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        mainViewModel.text.observe(this, Observer {
                value -> main_text.text = value
        })

         */

        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> { //TODO NAVIGATE
                }
                LoginError ->  {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("Information unknown.")
                        .setPositiveButton("Try again") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })


        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString().trim()) // to delete space
        }
    /* TO DO
        create_account_button.setOnClickListener {
            mainViewModel.onClickedLogin("Useless value", "essai")

        }


     */

        // Incremental button
        /*
        mainViewModel.number.observe(this, Observer{
            value -> button.text = value.toString()
        })

         */

    }
}