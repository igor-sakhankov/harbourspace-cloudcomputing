package com.harbourspace.cloudcomputing.coffeeshop.controllers

import com.harbourspace.cloudcomputing.coffeeshop.dtos.CreateEmailCommand
import com.harbourspace.cloudcomputing.coffeeshop.services.MessagePublisherService
import com.harbourspace.cloudcomputing.coffeeshop.services.UserService
import org.springframework.web.bind.annotation.PostMapping

@org.springframework.web.bind.annotation.RestController
class UserController(val userService: UserService, val messagePublisherService: MessagePublisherService) {
    @PostMapping("/v1/user")
    fun createUser(): String {
        userService.createUser()
        userService.createUser()
        userService.createUser()
        return "User created."
    }

    @PostMapping("/v2/user")
    fun createUserWithQueue(): String {
        messagePublisherService.sendEmailCommand(CreateEmailCommand(1, "harbour@harbour.com"))
        return "User created."
    }


    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}