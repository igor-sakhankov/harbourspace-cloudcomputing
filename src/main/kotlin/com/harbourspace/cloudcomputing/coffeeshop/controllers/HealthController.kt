package com.harbourspace.cloudcomputing.coffeeshop.controllers

import org.springframework.web.bind.annotation.GetMapping

@org.springframework.web.bind.annotation.RestController
class HealthController {

    @GetMapping("/healthy")
    fun healthy(): String {
        return "{" +
                "\"status\": \"healthy\"" +
                "}"
    }
}