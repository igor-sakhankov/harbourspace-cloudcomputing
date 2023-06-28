package com.harbourspace.cloudcomputing.coffeeshop.configs

import lombok.AccessLevel
import lombok.RequiredArgsConstructor
import lombok.Value
import java.util.*

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Value
class EndpointConfiguration(
    var protocol: String?,
    var host: String?,
    var port: Int = 0,
    var accessName: String?,
    var key: String?
) {

    fun getAccessName(): Optional<String> {
        return Optional.ofNullable(accessName)
    }

    fun getKey(): Optional<String> {
        return Optional.ofNullable(key)
    }

    val endpoint: String
        get() = String.format("%s:%s", host, port)
    val endpointWithProtocol: String
        get() = String.format("%s//%s:%s", protocol, host, port)

    companion object {
        private const val HTTP_PROTOCOL = "http:"
        val EMPTY = EndpointConfiguration(HTTP_PROTOCOL, null, 0, null, null)
        fun authenticated(
            host: String?, port: Int, accessName: String?, key: String?
        ): EndpointConfiguration {
            return EndpointConfiguration(HTTP_PROTOCOL, host, port, accessName, key)
        }

        fun hostOnly(host: String?, port: Int): EndpointConfiguration {
            return EndpointConfiguration(HTTP_PROTOCOL, host, port, null, null)
        }
    }
}
