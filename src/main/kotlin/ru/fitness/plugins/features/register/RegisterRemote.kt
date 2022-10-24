package ru.fitness.plugins.features.register

import kotlinx.serialization.Serializable

/**
 * @author Dgryzhkov
 */
@Serializable
data class RegisterReceiveRemote(
    val login: String,
    val email: String,
    val password: String
)

@Serializable
data class RegisterResponseRemote(
    val token: String
)