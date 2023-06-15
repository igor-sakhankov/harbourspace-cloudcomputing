package com.harbourspace.cloudcomputing.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class Votes(@JsonProperty("lastName") val lastName: String, @JsonProperty("votes") val votes: Int) {
}