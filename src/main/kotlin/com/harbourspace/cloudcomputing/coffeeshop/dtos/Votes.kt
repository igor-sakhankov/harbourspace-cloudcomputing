package com.harbourspace.cloudcomputing.coffeeshop.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class Votes(@JsonProperty("lastName") val lastName: String, @JsonProperty("votes") val votes: Int) {
}