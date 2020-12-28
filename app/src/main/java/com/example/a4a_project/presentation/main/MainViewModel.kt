package com.example.a4a_project.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4a_project.ApiInterface
import com.example.a4a_project.data.Ghibli
import com.example.a4a_project.domain.entity.User
import com.example.a4a_project.domain.usecase.CreateUserUseCase
import com.example.a4a_project.domain.usecase.GetUserUseCase
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val text : MutableLiveData<String> = MutableLiveData()
    val number : MutableLiveData<Int> = MutableLiveData()
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()
    val createLiveData : MutableLiveData<CreateStatus> = MutableLiveData()

    init{
        number.value = 0
        text.value = "Bonjour bonjour"
    }

    fun onClickedIncrement(){
        number.value = (number.value ?: 0) + 1
    }
    fun onClickedLogin(username: String, password: String){

        //On change de thread (similar to coroutine)
        viewModelScope.launch(Dispatchers.IO){ // Operations lourdes sur un thread background
            //createUserUseCase.invoke(User("test"))
            //delay(1000)
            val user : User? = getUserUseCase.invoke(username, password)
            val loginStatus = if (user != null ){
                LoginSuccess(user.username, user.password)
            }else{
                LoginError
            }
            withContext(Dispatchers.Main){//Main thread
                loginLiveData.value = loginStatus

            }

        }

    }
    //Change on Click ?
    fun onClickedCreate(username: String, password: String){

        //On change de thread (similar to coroutine)
        viewModelScope.launch(Dispatchers.IO){ // Operations lourdes sur un thread background


            val user : User? = getUserUseCase.invoke(username, password) // Check if the information are already in the database
            val CreateStatus = if (user != null && username != null && password != null){ //Already exist
                CreateError
            }else{
                createUserUseCase.invoke(User(username, password))
                CreateSuccess
            }
            val debug = "debug"
            withContext(Dispatchers.Main){//Main thread
                createLiveData.value = CreateStatus

            }


        }

    }



}