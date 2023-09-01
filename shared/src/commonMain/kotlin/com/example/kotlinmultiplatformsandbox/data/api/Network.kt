package com.example.kotlinmultiplatformsandbox.data.api

import com.example.kotlinmultiplatformsandbox.data.model.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
}

interface Network {
    suspend fun getRockets(): List<RocketLaunch>
}

class NetworkImpl : Network {
    override suspend fun getRockets(): List<RocketLaunch> {
        return httpClient.get(SPACE_X_API_URI).body()
    }
}


const val SPACE_X_API_URI = "https://api.spacexdata.com/v4/launches"