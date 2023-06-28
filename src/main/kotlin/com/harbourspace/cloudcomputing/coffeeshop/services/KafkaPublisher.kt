package com.harbourspace.cloudcomputing.coffeeshop.services

import com.harbourspace.cloudcomputing.coffeeshop.TOPIC
import org.springframework.context.annotation.Profile
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Profile("aws")
@Service
class KafkaPublisher(val kafkaTemplate: KafkaTemplate<String, String>) {
    fun publishMessage(key: String, value: String) {
        kafkaTemplate.send(TOPIC, key, value)
    }
}