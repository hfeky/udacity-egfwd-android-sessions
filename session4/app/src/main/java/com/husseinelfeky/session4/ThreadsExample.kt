package com.husseinelfeky.session4

import kotlin.concurrent.thread

fun main() {
    val startTime = System.currentTimeMillis()

    repeat(1_000_000) {
        thread {
            println("Hello World!")
        }
    }

    val endTime = System.currentTimeMillis()
    val duration = endTime - startTime

    println("Duration: $duration ms")
}
