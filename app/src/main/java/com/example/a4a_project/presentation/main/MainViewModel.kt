package com.example.a4a_project.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4a_project.domain.entity.User
import com.example.a4a_project.domain.usecase.CreateUserUseCase
import com.example.a4a_project.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainViewModel(
    val createUserUseCase: CreateUserUseCase, //Si on veut que ce soit MainViewModel qui le crée
    val getUserUseCase: GetUserUseCase

) : ViewModel(){

    val text : MutableLiveData<String> = MutableLiveData()
    val number : MutableLiveData<Int> = MutableLiveData()
    val mail : MutableLiveData<String> = MutableLiveData()

    init{ // Initialize its class variable
        number.value = 0
        text.value = "Bonjour bonjour"
    }

    fun onClickedIncrement(){
        number.value = (number.value ?: 0) + 1
    }


    fun onClickedEmail(emailUser : String){
        //On change de thread (similar to coroutine)
        viewModelScope.launch(Dispatchers.IO){
            createUserUseCase.invoke(User("test"))
            delay(1000)
            val user = getUserUseCase.invoke("test")
            val debug = "debug"
        }

    }
}