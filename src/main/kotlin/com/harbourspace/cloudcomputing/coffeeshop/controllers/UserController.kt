package com.harbourspace.cloudcomputing.coffeeshop.controllers

import com.google.gson.Gson
import com.harbourspace.cloudcomputing.coffeeshop.dtos.CreateEmailCommand
import com.harbourspace.cloudcomputing.coffeeshop.services.KafkaPublisher
import com.harbourspace.cloudcomputing.coffeeshop.services.MessagePublisherService
import com.harbourspace.cloudcomputing.coffeeshop.services.UserService
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@org.springframework.web.bind.annotation.RestController
@Profile("aws")
class UserController(
    val userService: UserService,
    val messagePublisherService: MessagePublisherService,
    val kafkaPublisher: KafkaPublisher
) {
    private val gson: Gson = Gson()

    @PostMapping("/v1/user")
    fun createUser(): String {
        userService.createUser()
        userService.createUser()
        userService.createUser()
        return "User created."
    }

    @PostMapping("/v2/user")
    fun createUserWithQueue(@RequestBody command: CreateEmailCommand ): String {
        kafkaPublisher.publishMessage(command.userId.toString(), command.userId.toString() + "user created")
        messagePublisherService.sendEmailCommand(command)
        kafkaPublisher.publishMessage(command.userId.toString(), command.userId.toString() +  "email sent")
        return "User created."
    }
}