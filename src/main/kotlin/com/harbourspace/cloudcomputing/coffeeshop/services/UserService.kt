package com.harbourspace.cloudcomputing.coffeeshop.services

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class UserService {
    @Async("executorService")
    fun createUser() {
        // here we would do some work to create a user
        // like sending email, SMS, etc.
        Thread.sleep(5000);
        println("Async method was executed" + Instant.now())
    }
}