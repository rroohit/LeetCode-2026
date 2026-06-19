package f_june

fun main() {

    val testCases = listOf(
        intArrayOf(-5, 1, 5, 0, -7),
        intArrayOf(-4, -3, -2, -1, 4, 3, 2)
    )

    testCases.forEach { gain ->
        println("Result ==> ${largestAltitude(gain)}")
    }

}

// TC - O(n) :: SC - O(1)
fun largestAltitude(gain: IntArray): Int {
    var altMx = 0
    var altCurr = 0
    for (alt in gain) {
        altCurr += alt
        if (altCurr > altMx) altMx = altCurr
    }
    return altMx
}