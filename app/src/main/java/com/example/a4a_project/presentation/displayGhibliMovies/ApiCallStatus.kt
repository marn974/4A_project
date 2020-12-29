package com.example.a4a_project.presentation.displayGhibliMovies


sealed class ApiCallStatus
object ApiCallSuccess : ApiCallStatus()
object ApiCallFailed : ApiCallStatus()

