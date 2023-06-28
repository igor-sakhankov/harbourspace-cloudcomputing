package com.harbourspace.cloudcomputing.coffeeshop.controllers

import com.harbourspace.cloudcomputing.coffeeshop.dtos.Votes
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@org.springframework.web.bind.annotation.RestController
class WebSocketController {

    @PostMapping("/websocket")
    fun healthy(@RequestBody votes: Votes): String {
        return "{" +
                "\"received\": \"${votes.lastName}\"" +
                "}"
    }
}