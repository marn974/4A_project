package com.example.a4a_project.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4a_project.domain.entity.User
import com.example.a4a_project.domain.usecase.CreateUserUseCase
import com.example.a4a_project.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class MainViewModel(
    private val createUserUseCase : CreateUserUseCase,
    private val getUserUseCase : GetUserUseCase
) : ViewModel(){
    val text : MutableLiveData<String> = MutableLiveData()
    val number : MutableLiveData<Int> = MutableLiveData()
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    init{
        number.value = 0
        text.value = "Bonjour bonjour"
    }

    fun onClickedIncrement(){
        number.value = (number.value ?: 0) + 1
    }
    fun onClickedLogin(emailUser : String, password : String){
        //On change de thread (similar to coroutine)
        viewModelScope.launch(Dispatchers.IO){ // Operations lourdes sur un thread background
            //createUserUseCase.invoke(User("test"))
            //delay(1000)
            val user : User? = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null ){
                LoginSuccess(user.email)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){//Main thread
                loginLiveData.value = loginStatus

            }

        }

    }


}