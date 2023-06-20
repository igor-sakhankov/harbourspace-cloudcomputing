package com.harbourspace.cloudcomputing.coffeeshop.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Configuration
class Config {
    @Bean("executorService")
    fun executorService(): ExecutorService {
        return Executors.newFixedThreadPool(1)
    }
}
