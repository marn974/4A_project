package com.example.a4a_project.presentation.loginPage

sealed class CreateStatus

object CreateSuccess : CreateStatus()
object CreateError : CreateStatus()
object CreateErrorUser : CreateStatus()
object CreateErrorPassword : CreateStatus()
