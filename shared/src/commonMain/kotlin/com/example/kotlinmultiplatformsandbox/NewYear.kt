package com.example.kotlinmultiplatformsandbox

import kotlinx.datetime.*

fun daysUntilNewYear(): Int {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    val closestYear = LocalDate(year = today.year + 1, monthNumber = 1, dayOfMonth = 1)
    return today.daysUntil(closestYear)
}