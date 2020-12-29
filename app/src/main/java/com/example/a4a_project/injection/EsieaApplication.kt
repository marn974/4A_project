package com.example.a4a_project.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
//Koin permet de faire des classes plus facilement avec des singletons


class EsieaApplication : Application(){ // In android, application is a class but we can extend it
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@EsieaApplication)
            // modules
            modules(presentationModule, domain, dataModule) //Où on déclare les modules
        }
    }
}