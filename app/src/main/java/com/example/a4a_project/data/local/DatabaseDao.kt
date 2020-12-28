package com.example.a4a_project.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.a4a_project.data.local.models.UserLocal


@Dao
interface DatabaseDao {

    @Query(value = "SELECT * FROM UserLocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM UserLocal WHERE Username LIKE :givenUserName AND " +
            "Password LIKE :givenPassword LIMIT 1")
    fun findByLoginInformation(givenUserName: String, givenPassword : String): UserLocal ?


    @Query("SELECT * FROM UserLocal WHERE UserLocal.Username LIKE :username LIMIT 1")
    fun findByUsername(username: String): UserLocal

    @Insert
    fun insert(user: UserLocal)

    @Delete
    fun delete(user: UserLocal)

}