package com.example.a4a_project.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4a_project.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

}