package com.example.a4a_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import org.koin.android.ext.android.inject

class MainViewModel : AppCompatActivity(){

    val text : MutableLiveData<String> = MutableLiveData()
    val number : MutableLiveData<Int> = MutableLiveData()

    init{
        number.value = 0
        text.value = "Bonjour bonjour"
    }

    fun onClickedIncrement(){
        number.value = (number.value ?: 0) + 1
    }
}