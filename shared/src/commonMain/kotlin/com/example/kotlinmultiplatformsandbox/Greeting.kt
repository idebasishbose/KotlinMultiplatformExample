package com.example.kotlinmultiplatformsandbox

import com.example.kotlinmultiplatformsandbox.data.api.Network
import com.example.kotlinmultiplatformsandbox.data.api.NetworkImpl
import com.example.kotlinmultiplatformsandbox.data.model.RocketLaunch

class Greeting {
    private val platform: Platform = getPlatform()

    @Throws(Exception::class)
    suspend fun greet(): String {
        val network: Network = NetworkImpl()
        val rockets: List<RocketLaunch> = network.getRockets()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }

        return "Guess what it is! > ${platform.name}! " +
                "+ \n\nThere are only ${daysUntilNewYear()} " +
                "days left until New Year! \uD83C\uDF86\"" +
                "\n\nSpace x latest rocket launch ${lastSuccessLaunch.launchDateUTC}"
    }
}