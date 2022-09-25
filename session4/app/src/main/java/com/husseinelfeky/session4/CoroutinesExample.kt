package com.husseinelfeky.session4

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val startTime = System.currentTimeMillis()

    runBlocking {
        repeat(1_000_000) {
            launch {
                println("Hello World!")
            }
        }
    }

    val endTime = System.currentTimeMillis()
    val duration = endTime - startTime

    println("Duration: $duration ms")
}
