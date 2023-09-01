package com.example.kotlinmultiplatformsandbox.android

import androidx.lifecycle.ViewModel
import com.example.kotlinmultiplatformsandbox.Greeting

class GreetingViewModelImpl : ViewModel(), GreetingViewModel {
    private val greeting = Greeting()
    override suspend fun greet(): String {
        return greeting.greet()
    }
}