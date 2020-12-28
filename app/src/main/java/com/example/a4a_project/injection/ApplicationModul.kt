package com.example.a4a_project.injection
import android.content.Context
import androidx.room.Room
import com.example.a4a_project.data.local.AppDatabase
import com.example.a4a_project.data.local.DatabaseDao
import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.usecase.CreateUserUseCase
import com.example.a4a_project.domain.usecase.GetUserUseCase
import com.example.a4a_project.domain.usecase.GetUsernameUseCase
import com.example.a4a_project.presentation.accountCreation.CreateAccountViewModel
import com.example.a4a_project.presentation.list.DataGhibliViewModel
import com.example.a4a_project.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
//Create the object
// Define how each class object is instantiated ?
val presentationModule = module{
    factory { MainViewModel(get(), get()) }
    factory { CreateAccountViewModel(get(), get()) }
    factory { DataGhibliViewModel() }
}

val domain : Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetUsernameUseCase(get()) }
}

val dataModule : Module = module {
    single {UserRepository(get())}
    single {CreateDatabase(androidContext())}
}

fun CreateDatabase(context: Context): DatabaseDao {
        val appDatabase : AppDatabase= Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
        appDatabase.databaseDao()
        return appDatabase.databaseDao()
}

