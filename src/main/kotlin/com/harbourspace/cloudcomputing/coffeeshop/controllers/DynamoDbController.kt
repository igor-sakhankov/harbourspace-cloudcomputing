package com.harbourspace.cloudcomputing.coffeeshop.controllers

import com.harbourspace.cloudcomputing.coffeeshop.repositories.HarbourUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DynamoDbController(val harbourUserRepository: HarbourUserRepository) {

    @GetMapping("/v1/user/{id}/{drink}")
    fun getUser(@PathVariable id: Long, @PathVariable drink: String): String {
        val user = harbourUserRepository.findByUserId(id, drink)
        return user.toString()
    }

    @PostMapping("/v1/user/{id}/{drink}")
    fun updateUser(@PathVariable id: Long, @PathVariable drink: String): String {
        val user = harbourUserRepository.updateUser(id, drink)
        return user.toString()
    }

    @PostMapping("/v1/user/{id}/{drink}/{city}")
    fun updateUserWithCity(@PathVariable id: Long, @PathVariable drink: String, @PathVariable city: String): String {
        val user = harbourUserRepository.updateUser(id, drink, city)
        return user.toString()
    }
}