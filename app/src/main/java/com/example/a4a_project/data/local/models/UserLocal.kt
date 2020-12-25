package com.example.a4a_project.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.a4a_project.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "email") val email: String
){
    @PrimaryKey(autoGenerate = true) var uid: Int? = null

}
//Mapping function
// on rajoute une fonction a User renvoyant une valeur de type Userlocal
// On return un object UserLocal initialisé avec l'entrée email (ci-dessus)
fun User.toData() : UserLocal {
 return UserLocal(email = email)
}

fun UserLocal.toEntity() : User {
    return User(email = email)
}