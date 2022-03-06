package ru.andrewgo.demo.application

import io.ktor.application.call
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "127.0.0.1") {
        routing {
            get("/") {
                call.respondText { "hello" }
            }
            static("/") {
                resources("")
            }
        }
    }.start(wait = true)
}