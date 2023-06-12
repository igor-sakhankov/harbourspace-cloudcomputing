package com.harbourspace.cloudcomputing.coffeeshop.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

@RestController
class LoadTestingController {

    @GetMapping("/v1/loadtest")
    fun getLoadTest(): String {
        val iterations = 1000000
        val a = 0.0000
        var result = mutableListOf<Double>()

        for (i in 0 until iterations) {
            result.add(sqrt(ln(i.toDouble().pow(ln(i.toDouble())) + a)))
        }
        return result.size.toString()
    }
}