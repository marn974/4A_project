package com.example.a4a_project.presentation.accountCreation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4a_project.domain.entity.User
import com.example.a4a_project.domain.usecase.CreateUserUseCase
import com.example.a4a_project.domain.usecase.GetUsernameUseCase
import com.example.a4a_project.presentation.main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val getUsernameUseCase: GetUsernameUseCase,
    private val createUserUseCase: CreateUserUseCase
) : ViewModel(){

    val createLiveData: MutableLiveData<CreateStatus> = MutableLiveData()


    fun onClickedCreate(username: String, password: String, passwordCheckingValue : String) {

        //On change de thread (similar to coroutine)
        viewModelScope.launch(Dispatchers.IO) { // Operations lourdes sur un thread background


            val user: String? = getUsernameUseCase.invoke(username)
            Log.i("Check User name" , " " + user)
            /* Check if the information are already in the database */
            val CreateStatus =
                if (user != null && username != null && password != null && passwordCheckingValue != null) { //Already exist
                    if (user!=null){
                    //User already exist
                        Log.i("CREATE_ERROR_USER ", "user != null" + user + " " + username + " " + password +" " + passwordCheckingValue)
                        CreateErrorUser //Prob
                    }
                    else{
                        Log.i("CREATE_ERROR", "user != null" + user + " " + username + " " + password +" " + passwordCheckingValue)
                        CreateError
                    }


                } else {
                    if (password != passwordCheckingValue) // Passwords not matching{
                    {
                        Log.i("CREATE_ERROR_PASSWORD ", "user != null" + user + " " + username + " " + password +" " + passwordCheckingValue)
                        CreateErrorPassword
                    }
                    else{
                        Log.i("CREATE_SUCCESS ", "user != null" + user + " " + username + " " + password +" " + passwordCheckingValue)
                        createUserUseCase.invoke(User(username, password))
                        CreateSuccess
                    }


                }
            withContext(Dispatchers.Main) {//Main thread
                createLiveData.value = CreateStatus

            }


        }

    }
}