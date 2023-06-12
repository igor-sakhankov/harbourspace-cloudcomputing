package com.harbourspace.cloudcomputing.coffeeshop.controllers

import com.harbourspace.cloudcomputing.coffeeshop.controllers.vms.DataVm
import com.harbourspace.cloudcomputing.coffeeshop.controllers.vms.FavouriteCoffeeVm
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeShopController {

    @GetMapping("/v1/coffee/favourite")
    fun getCoffeeShop(@RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String): DataVm<FavouriteCoffeeVm> {
        if(authHeader != "my_test_header") {
            throw Exception("Invalid auth header")
        }

        return DataVm(FavouriteCoffeeVm("Cappuccino"))
    }
}