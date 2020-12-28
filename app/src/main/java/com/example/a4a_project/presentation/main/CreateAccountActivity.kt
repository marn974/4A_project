package com.example.a4a_project.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.a4a_project.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.create_account_button
import kotlinx.android.synthetic.main.activity_main.login_edit
import kotlinx.android.synthetic.main.activity_main.password_edit
import org.koin.android.ext.android.inject

class CreateAccountActivity : AppCompatActivity() {
    val createAccountViewModel: CreateAccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        createAccountViewModel.createLiveData.observe(this, Observer {
            when (it) {
                is CreateSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("THIS IS A WIN!")
                        .setMessage("You are part of the family now !")
                        .setPositiveButton("Nice !") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
                CreateError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("URK")
                        .setMessage("Information are missing. Please fill all the fields.")
                        .setPositiveButton("Try again") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }

                CreateErrorPassword -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("OH!")
                        .setMessage("The password fields are not matching. Please give the same password")
                        .setPositiveButton("Try again") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }

                CreateErrorUser -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("WHOOPS!")
                        .setMessage("A user already use this login. No worry, just find something else ;).")
                        .setPositiveButton("Try again") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }

            }
        })

        create_account_button.setOnClickListener {
            if(!login_edit.text.toString().trim().equals("") && !password_edit.text.toString().trim().equals("") && !password_edit_checking.text.toString().trim().equals(""))
                createAccountViewModel.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString().trim(), password_edit_checking.text.toString().trim()) // to delete space
            else
                Toast.makeText(this,"Please fill all the fields.", Toast.LENGTH_LONG).show()
        }
    }
}