package com.example.wokebackend.service

import com.example.wokebackend.model.User
import com.example.wokebackend.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun registerUser(user: User): User {
        return userRepository.save(user)
    }

    fun authenticate(username: String, password: String): User? {
        val user = userRepository.findByUsername(username) ?: return null
        return if (user.password == password) user else null
    }

    fun getUserInfo(userId: Long): User? {
        return userRepository.findById(userId).orElse(null)
    }
}
