package com.harbourspace.cloudcomputing.coffeeshop.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateEmailCommand(@JsonProperty("id") val userId: Long, @JsonProperty("email") val email: String) {
}