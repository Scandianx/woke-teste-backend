package com.example.wokebackend.controller

import com.example.wokebackend.model.User
import com.example.wokebackend.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = ["http://localhost:3000"])
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        val registeredUser = userService.registerUser(user)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<Long> {
        val user = userService.authenticate(loginRequest.username, loginRequest.password)
        return if (user != null) {
            ResponseEntity.ok(user.id)
        } else {
            ResponseEntity.status(401).build()
        }
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.getUserInfo(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(user)
    }

    @GetMapping("/sendUserData")
    fun sendUserData(@RequestHeader("Authorization") token: String, @RequestParam id: Long): ResponseEntity<Any> {
        if (token != "valid-token") {
            return ResponseEntity.status(403).body("Token inválido")
        }
        val user = userService.getUserInfo(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(user)
    }
}

data class LoginRequest(val username: String, val password: String)

