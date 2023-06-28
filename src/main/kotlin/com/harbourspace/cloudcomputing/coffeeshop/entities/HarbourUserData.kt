package com.harbourspace.cloudcomputing.coffeeshop.entities

import lombok.Getter
import lombok.Setter
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
@Getter
@Setter
data class HarbourUserData @JvmOverloads constructor(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("UserId")
    var UserId: Long = 0,
    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("PreferredDrink")
    var preferredDrink: String = "",
    @get:DynamoDbAttribute("City")
    var city: String? = ""
)
