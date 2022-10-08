package com.husseinelfeky.session6.kotlindelegates

import kotlin.properties.Delegates

/**
 * Returns a property delegate for a read/write property that calls a specified callback function
 * when changed.
 */
var number: Int by Delegates.observable(0) { _, oldValue, newValue ->
    println("Old Value: $oldValue, New Value: $newValue")
}

fun main() {
    number = 20 // Print 0, 20
    number = 40 // Print 20, 40
    number = 10 // Print 40, 10
}
