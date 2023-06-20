package com.harbourspace.cloudcomputing.coffeeshop.controllers

import com.harbourspace.cloudcomputing.coffeeshop.services.BaristaService
import com.harbourspace.cloudcomputing.coffeeshop.dtos.Votes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BaristaController(val service: BaristaService) {
    @PostMapping("/addVotes")
    fun updateSpeaker(@RequestBody votes: Votes): ResponseEntity<String> {
        return try {
            service.addVotesToBarista(votes)
            ResponseEntity("Votes successfully added.", HttpStatus.ACCEPTED)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.CONFLICT)
        }
    }
}