package com.example.a4a_project.presentation.displayGhibliMovies

sealed class DataSetStatus
object DataSetNotEmpty : DataSetStatus()
object DataSetEmpty : DataSetStatus()
