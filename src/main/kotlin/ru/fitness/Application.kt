package ru.fitness

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import ru.fitness.plugins.*
import ru.fitness.plugins.features.login.configureLoginRouting
import ru.fitness.plugins.features.register.configureRegisterRouting

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
    }.start(wait = true)
}
