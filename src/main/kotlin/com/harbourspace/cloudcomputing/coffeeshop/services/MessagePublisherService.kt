package com.harbourspace.cloudcomputing.coffeeshop.services

import com.amazonaws.services.sqs.AmazonSQS
import com.google.gson.Gson
import com.harbourspace.cloudcomputing.coffeeshop.dtos.CreateEmailCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Profile("aws")
@Service
class MessagePublisherService(
    @Value("\${app.config.message.queue.topic}") val messageQueueTopic: String,
    val amazonSQSClient: AmazonSQS
) {

    private val gson: Gson = Gson()
    fun sendEmailCommand(emailCommand: CreateEmailCommand) {
        try {
            val queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic);
            val toJson = gson.toJson(emailCommand)
            amazonSQSClient.sendMessage(
                queueUrl.queueUrl,
                toJson
            );
        } catch (e: Exception) {
            // do nothing
            println(e.message)
        }
    }
}