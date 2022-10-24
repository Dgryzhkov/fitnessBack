package ru.fitness.plugins.features.login

import kotlinx.serialization.Serializable

/**
 * @author Dgryzhkov
 */
@Serializable
data class LoginReceiveRemote(
    val login: String,
    val password: String
)

@Serializable
data class LoginResponseRemote(
    val token: String
)