package com.harbourspace.cloudcomputing.coffeeshop.configs

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("aws")
@Configuration
class SQSClientConfiguration(
    @Value("\${app.config.aws.access_key_id}")
    val awsAccessKeyId: String,
    @Value("\${app.config.aws.secret_key_id}")
    val awsSecretKeyId: String,
    @Value("\${app.config.aws.region}") val awsRegion: String
) {
    @Bean
    fun amazonSQSClient(): AmazonSQS {
        val awsCredentials = BasicAWSCredentials(awsAccessKeyId, awsSecretKeyId)
        return AmazonSQSClientBuilder.standard()
            .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
            .withRegion(awsRegion)
            .build()
    }
}