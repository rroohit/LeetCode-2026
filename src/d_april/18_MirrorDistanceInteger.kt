package d_april

import kotlin.math.abs

fun main() {

    val testCases = listOf(
        25, 10, 7, 1, 44, 55, 23, 86
    )

    testCases.forEach { n ->
        println("Result ==> ${mirrorDistance(n)}")
    }
}

// TC - O(log n), SC - O(1)
private fun mirrorDistance(n: Int): Int {
    return abs(n - getRev(n))
}

private fun getRev(num: Int): Int {
    var n = num
    var rev = 0
    while (n > 0) {
        val digit = n % 10
        rev = (rev * 10) + digit
        n /= 10
    }
    return rev
}