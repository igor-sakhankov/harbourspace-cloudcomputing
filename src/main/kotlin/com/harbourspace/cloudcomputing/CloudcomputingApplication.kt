package com.harbourspace.cloudcomputing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableRetry
@EnableAsync
@EnableScheduling
class CloudcomputingApplication

fun main(args: Array<String>) {
	runApplication<CloudcomputingApplication>(*args)
}
