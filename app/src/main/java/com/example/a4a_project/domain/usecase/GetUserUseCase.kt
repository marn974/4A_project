package com.example.a4a_project.domain.usecase

import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.entity.User


class GetUserUseCase (
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User ?{
        return userRepository.getUser(email)
    }

}