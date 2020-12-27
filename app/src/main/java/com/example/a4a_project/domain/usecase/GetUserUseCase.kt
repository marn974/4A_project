package com.example.a4a_project.domain.usecase

import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.entity.User


class GetUserUseCase (
    private val userRepository: UserRepository
) {

    suspend fun invoke(username: String, password : String) : User ?{
        return userRepository.getUser(username,password)
    }

}