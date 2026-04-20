package d_april

fun main() {

    val testCases = listOf(
        intArrayOf(1, 1, 1, 6, 1, 1, 1),
        intArrayOf(1, 8, 3, 8, 3),
        intArrayOf(0, 1)
    )

    testCases.forEach { colors ->
        println("Result ==> ${maxDistance(colors)}")
    }

}

private fun maxDistance(colors: IntArray): Int {
    var maxDist = 0
    for (i in colors.indices) {
        if (colors[i] != colors[0] && i > maxDist) maxDist = i
        if (colors[i] != colors[colors.size - 1]) maxDist = maxOf(colors.size - i - 1, maxDist)
    }
    return maxDist
}
