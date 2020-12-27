package com.example.a4a_project.presentation.main

sealed class CreateStatus

object CreateSuccess : CreateStatus()
object CreateError : CreateStatus()
