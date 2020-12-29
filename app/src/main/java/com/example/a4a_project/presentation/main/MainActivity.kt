package com.example.a4a_project.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.a4a_project.R
import com.example.a4a_project.presentation.accountCreation.CreateAccountActivity
import com.example.a4a_project.presentation.displayGhibliMovies.DataGhibliActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    val intent = Intent(this, DataGhibliActivity::class.java)
                    startActivity(intent)

                }
                LoginError ->  {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error login")
                        .setMessage("Information unknown.")
                        .setPositiveButton("Try again") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })





        login_button.setOnClickListener {
            if (!login_edit.text.toString().trim().equals("") && !password_edit.text.toString()
                    .trim().equals("")
            )
                mainViewModel.onClickedLogin(
                    login_edit.text.toString().trim(),
                    password_edit.text.toString().trim()
                ) // to delete space
            else
                Toast.makeText(this, "Please fill all the fields.", Toast.LENGTH_LONG).show()
        }

        //Add activity ?
        create_account_button.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            Log.i("Create account button", "CLIKED")
            startActivity(intent)
        }




    }
}