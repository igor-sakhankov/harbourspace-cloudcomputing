package com.harbourspace.cloudcomputing.coffeeshop.services

import com.harbourspace.cloudcomputing.coffeeshop.TOPIC
import com.harbourspace.cloudcomputing.coffeeshop.TOPIC_USER
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaListener {
    @KafkaListener(id = "consumer1", topics = [TOPIC], groupId = "my-group-1")
    fun listen(value: String?) {
        println("Consumer1:" +value)
    }

    @KafkaListener(id = "consumer21", topics = [TOPIC_USER], groupId = "my-group-2")
    fun listen2(value: String?) {
        println("Consumer2:" + value)
    }
}