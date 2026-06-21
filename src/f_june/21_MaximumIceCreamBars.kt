package f_june

fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 2, 4, 1), 7
        ),
        Pair(
            intArrayOf(10, 6, 8, 7, 7, 8), 5
        ),
        Pair(
            intArrayOf(1, 6, 3, 1, 2, 5), 20
        )
    )

    testCases.forEach { (costs, coins) ->
        println("Result ==> ${maxIceCream(costs, coins)}")
    }

}

// TC - O(n + m) :: SC - O(m)
fun maxIceCream(costs: IntArray, coins: Int): Int {
    var mxCst = 0
    for (cst in costs) if (cst > mxCst) mxCst = cst

    val costMap = IntArray(mxCst + 1)
    for (cst in costs) costMap[cst]++

    var remainingCoins = coins
    var totalCount = 0

    for (price in 1..<costMap.size) {

        if (remainingCoins < price) break

        val count = costMap[price]

        if (count == 0) continue

        val barsToBuy = minOf(count, remainingCoins / price)

        totalCount += barsToBuy
        remainingCoins -= barsToBuy * price
    }

    return totalCount
}

// TC - O(n logn) :: SC - O(log n)
fun maxIceCream1(costs: IntArray, coins: Int): Int {
    costs.sort()
    var cnt = 0
    var rem = coins
    for (cst in costs) {
        rem -= cst
        if (rem < 0) break
        cnt++
    }
    return cnt
}