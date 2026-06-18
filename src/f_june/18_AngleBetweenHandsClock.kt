package f_june

import kotlin.math.abs

fun main() {

    val testCases = listOf(
        Pair(12, 30)
    )

    testCases.forEach { (hour, minute) ->
        println("Result ==> ${angleClock(hour, minute)}")
    }

}

// TC - O(1) :: SC - O(1)
fun angleClock(hour: Int, minutes: Int): Double {
    val minuteAng = (minutes * 6.0)
    val hourAng = (hour * 30.0) + (minutes * 0.5)
    val diff = abs(hourAng - minuteAng)
    return minOf(diff, 360 - diff)
}