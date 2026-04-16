package d_april

import kotlin.math.abs

fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 1, 4, 1, 3, 2),
            intArrayOf(0, 3, 5)
        )
    )

    testCases.forEach { (nums, queries) ->
        println("Result ==> ${solveQueries(nums, queries)}")
    }

}

// TC - O(n log n), SC - O(n)
fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
    val n = nums.size
    val numInd = hashMapOf<Int, ArrayList<Int>>()

    for (i in 0..<n) {
        numInd.computeIfAbsent(nums[i]) { ArrayList() }.add(i)
    }

    for (i in queries.indices) {
        val currInd = queries[i]
        val list = numInd[nums[currInd]]
        if (list == null || list.size <= 1) {
            queries[i] = -1
            continue
        }

        val ln = list.size
        val pos = list.binarySearch(currInd)

        val prev = list[(pos - 1 + ln) % ln]
        val next = list[(pos + 1) % ln]

        queries[i] = minOf(
            n - abs(currInd - prev),
            abs(currInd - prev),
            n - abs(currInd - next),
            abs(currInd - next),
        )
    }

    return queries.toList()
}
