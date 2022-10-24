package ru.fitness.plugins.features.cache

import ru.fitness.plugins.features.register.RegisterReceiveRemote

/**
 * @author Dgryzhkov
 */

data class TokenCache(
    val login: String,
    val token: String
)


object InMemoryCache {
    val userList: MutableList<RegisterReceiveRemote> = mutableListOf()
    val token: MutableList<TokenCache> = mutableListOf()
}