package com.harbourspace.cloudcomputing.coffeeshop.repositories

import com.harbourspace.cloudcomputing.coffeeshop.entities.HarbourUserData
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.UpdateItemEnhancedRequest
import java.util.*

@Service
class HarbourUserRepository(
    private val dbClient: DynamoDbEnhancedAsyncClient
) {

    private lateinit var courierDataTable: DynamoDbAsyncTable<HarbourUserData>;

    @PostConstruct
    fun initialize() {
        courierDataTable = dbClient.table(
            TABLE_NAME,
            TableSchema.fromBean(HarbourUserData::class.java)
        )
    }

    fun findByUserId(userId: Long, drink: String): Optional<HarbourUserData> {
        return Optional.ofNullable(
            courierDataTable.getItem(Key.builder().partitionValue(userId).sortValue(drink).build()).join()
        )
    }

    fun updateUser(userId: Long, drink: String, city: String? = null): HarbourUserData {
        val data = HarbourUserData(
            UserId = userId,
            preferredDrink = drink,
            city = city
        )
        return courierDataTable
            .updateItem(
                UpdateItemEnhancedRequest.builder(HarbourUserData::class.java)
                    .ignoreNulls(true)
                    .item(data)
                    .build()
            )
            .join()
    }

    companion object {
        private const val TABLE_NAME = "harbour-coffee-shop-users"
    }
}
