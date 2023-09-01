package com.example.kotlinmultiplatformsandbox.android

interface GreetingViewModel {
    suspend fun greet(): String
}