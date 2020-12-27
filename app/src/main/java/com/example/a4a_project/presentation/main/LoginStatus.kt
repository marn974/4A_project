package com.example.a4a_project.presentation.main

//Spécifique à kotlin ~~ enum
sealed class LoginStatus

data class LoginSuccess(val email : String) : LoginStatus() // Class qui étant LoginStatusSealed
object LoginError : LoginStatus()
