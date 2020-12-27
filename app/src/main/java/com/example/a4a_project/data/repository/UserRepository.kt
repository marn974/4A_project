package com.example.a4a_project.data.repository

import com.example.a4a_project.data.local.DatabaseDao
import com.example.a4a_project.data.local.models.toData
import com.example.a4a_project.data.local.models.toEntity
import com.example.a4a_project.domain.entity.User
import kotlinx.android.synthetic.main.activity_main.view.*

class UserRepository(
    private val databaseDao : DatabaseDao
) {
    suspend fun createUser(user: User) {
        databaseDao.insert(user.toData())
    }

    //TO MODIFY pass word
    fun getUser(username: String, password : String) :User? {
        val userLocal = databaseDao.findByLoginInformation(username,password)
        return userLocal?.toEntity()
    }
}