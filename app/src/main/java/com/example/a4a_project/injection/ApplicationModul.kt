package com.example.a4a_project.injection
import androidx.lifecycle.MutableLiveData
import com.example.a4a_project.MainViewModel
import org.koin.dsl.module

val presentationModule = module{
    factory { MainViewModel()}
}

