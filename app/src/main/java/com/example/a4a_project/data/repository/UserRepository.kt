package com.example.a4a_project.data.repository

import com.example.a4a_project.data.local.DatabaseDao
import com.example.a4a_project.data.local.models.toData
import com.example.a4a_project.data.local.models.toEntity
import com.example.a4a_project.data.local.models.toUsername
import com.example.a4a_project.domain.entity.User
import kotlinx.android.synthetic.main.activity_main.view.*

class UserRepository(
    private val databaseDao : DatabaseDao
) {
    suspend fun createUser(user: User) {
        databaseDao.insert(user.toData())
    }


    fun getUser(username: String, password : String) :User? {
        val userLocal = databaseDao.findByLoginInformation(username,password)
        return userLocal?.toEntity()
    }

    fun getUsername(username: String) :String? {
        val userLocal = databaseDao.findByUsername(username)
        return userLocal?.toUsername()
    }
}