package com.husseinelfeky.session6.kotlindelegates

import kotlin.properties.Delegates

/**
 * Returns a property delegate for a read/write property that calls a specified callback function
 * when changed, allowing the callback to veto the modification.
 */
var max: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
    newValue > oldValue
}

fun main() {
    println(max) // 0

    max = 10
    println(max) // 10

    max = 5
    println(max) // 10
}
