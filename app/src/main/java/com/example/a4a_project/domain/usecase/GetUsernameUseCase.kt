package com.example.a4a_project.domain.usecase

import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.entity.User

class GetUsernameUseCase(
    private val userRepository: UserRepository
) {
    //Nous permet de faire les choses en asynchrones
    suspend fun invoke(username : String) : String?{
        return userRepository.getUsername(username)
    }
}