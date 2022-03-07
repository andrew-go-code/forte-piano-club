package ru.andrewgo.demo.application

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

suspend fun main() {
    initDbWithMockData() //need to commented out or removed after first start

    embeddedServer(Netty, port = 8081, host = "127.0.0.1") {
        install(ContentNegotiation) {
            json()
        }
        install(CORS) {
            method(HttpMethod.Get)
            method(HttpMethod.Post)
            method(HttpMethod.Delete)
            anyHost()
        }
        install(Compression) {
            gzip()
        }
        getRouting()
    }.start(wait = true)
}



