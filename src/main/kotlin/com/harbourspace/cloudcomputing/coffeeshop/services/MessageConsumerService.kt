package com.harbourspace.cloudcomputing.coffeeshop.services

import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.model.QueueDoesNotExistException
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class MessageConsumerService(
    @Value("\${app.config.message.queue.topic}")
    private val messageQueueTopic: String, private val amazonSQSClient: AmazonSQS
) {

    @Scheduled(fixedDelay = 5000)
    fun receiveMessages() {
        try {
            val queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic).queueUrl
            val receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl)
            if (receiveMessageResult.messages.isNotEmpty()) {
                val message = receiveMessageResult.messages[0]
                processCreateEmailRequest(message.body)
                amazonSQSClient.deleteMessage(queueUrl, message.receiptHandle)
            }
        } catch (e: Exception) {
            // do nothing
        }
    }

    private fun processCreateEmailRequest(body: String) {
        println("Received message: $body")
    }
}