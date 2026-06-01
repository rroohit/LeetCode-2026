package f_june

fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3),
        intArrayOf(6, 5, 7, 9, 2, 2),
        intArrayOf(5, 5)
    )

    testCases.forEach { cost ->
        println("Result ==> ${minimumCost(cost)}")
    }

}

// TC - O(n logn) :: SC - O(n)
fun minimumCost(cost: IntArray): Int {
    val n = cost.size
    cost.sort()
    var totalCost = 0
    var i = n - 1
    while (i >= 0) {
        totalCost += cost[i--]
        if (i < 0) break
        totalCost += cost[i--]
        if (i < 0) break
        i--
    }
    return totalCost
}