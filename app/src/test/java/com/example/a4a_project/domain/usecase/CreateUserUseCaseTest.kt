package com.example.a4a_project.domain.usecase

import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.entity.User

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test


class CreateUserUseCaseTest() {
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = CreateUserUseCase(userRepository) // on inject le mock

    @Test
    fun resendEmailSuccess(){
        runBlocking {
            //GIVEN
            val user = User("")
            coEvery { userRepository.createUser(user) } returns Unit
            //WHEN
            classUnderTest.invoke(user)
            //THEN
            coVerify(exactly = 1) { userRepository.createUser(user)} // Check the call ?
        }
    }
}