package ru.fitness.plugins.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.fitness.plugins.features.cache.InMemoryCache
import ru.fitness.plugins.features.cache.TokenCache
import ru.fitness.plugins.features.login.LoginResponseRemote
import ru.fitness.utils.isValidEmail
import java.util.*

/**
 * @author Dgryzhkov
 */
fun Application.configureRegisterRouting() {

    routing {
        post ("/register") {
            val receive = call.receive<RegisterReceiveRemote>()
            if (!receive.email.isValidEmail()) {
                call.respond(HttpStatusCode.BadRequest, "email is not valid")
            }
            if (InMemoryCache.userList.map { it.login }.contains(receive.login)) {
                call.respond(HttpStatusCode.Conflict, "User already exists")
            }

            val token = UUID.randomUUID().toString()
            InMemoryCache.userList.add(receive)
            InMemoryCache.token.add(TokenCache(login = receive.login, token = token))

            call.respond(RegisterResponseRemote(token = token))
        }
    }
}
