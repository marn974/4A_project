package com.example.a4a_project.domain.usecase

import com.example.a4a_project.data.repository.UserRepository
import com.example.a4a_project.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test


class GetUserUseCaseTest () {

    private val userRepository: UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository) // on inject le mock

    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            //GIVEN
            val username = ""
            val password = ""
            coEvery { userRepository.getUser(username,password) } returns null
            //WHEN
            val result = classUnderTest.invoke(username,password)
            //THEN
            coVerify(exactly = 1) { userRepository.getUser(username,password)}

            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid email`(){
        runBlocking {
            //GIVEN
            val username = "hemlo"
            val password = "password"
            val expectedUser = User(username)
            coEvery { userRepository.getUser(username,password) } returns expectedUser
            //WHEN
            val result = classUnderTest.invoke(username,password)
            //THEN
            coVerify(exactly = 1) { userRepository.getUser(username,password)}

            assertEquals(result,expectedUser)
        }
    }
}