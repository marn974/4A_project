package com.example.a4a_project.domain.usecase

import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.entity.User


class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    //Nous permet de faire les choses en asynchrones
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}