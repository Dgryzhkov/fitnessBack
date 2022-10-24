package ru.fitness.plugins

import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

/**
 * @author Dgryzhkov
 */

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
        }
    }
}