package com.example.a4a_project.presentation.list


sealed class ApiCallStatus
object ApiCallSuccess : ApiCallStatus()
object ApiCallFailed : ApiCallStatus()

