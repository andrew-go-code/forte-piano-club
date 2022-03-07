package ru.andrewgo.demo.application

import BarEventsHolder
import BarMenuHolder
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.getRouting() {
    routing {
        get("/") {
            call.respondText(
                this::class.java.classLoader.getResource("index.html")!!.readText(),
                ContentType.Text.Html
            )
        }
        static("/") {
            resources("")
        }
        route(BarEventsHolder.path) {
            get {
                call.respond(barEventsHolderCollection.find().toList())
            }
        }
        route(BarMenuHolder.path) {
            get {
                call.respond(barMenuHolderCollection.find().toList())
            }
        }
    }
}