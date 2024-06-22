package com.example.wokebackend

import com.example.wokebackend.model.User
import com.example.wokebackend.repository.UserRepository
import com.example.wokebackend.service.UserService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class UserServiceTests {

    private val userRepository = mock(UserRepository::class.java)
    private val userService = UserService(userRepository)

    @Test
    fun `registerUser should save user`() {
        val user = User(username = "test", password = "password", fullName = "Test User", phone = "123456789", email = "test@example.com", birthDate = "01/01/1990")
        `when`(userRepository.save(any(User::class.java))).thenReturn(user)

        val registeredUser = userService.registerUser(user)

        assertEquals(user, registeredUser)
    }

    @Test
    fun `authenticate should return true for valid credentials`() {
        val user = User(username = "test", password = "password", fullName = "Test User", phone = "123456789", email = "test@example.com", birthDate = "01/01/1990")
        `when`(userRepository.findByUsername("test")).thenReturn(user)

        val result = userService.authenticate("test", "password")

        assertEquals(user, result)
    }

    
}
