package com.example.a4a_project.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a4a_project.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "Username") val username: String,
    @ColumnInfo(name = "Password") val password: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null

}
//Mapping function
// on rajoute une fonction a User renvoie une valeur de type Userlocal
// On return un object UserLocal initialisé avec l'entrée email (ci-dessus)
fun User.toData() : UserLocal {
 return UserLocal(username = username, password = password)
}

fun UserLocal.toEntity() : User {
    return User(username = username, password = password)
}

