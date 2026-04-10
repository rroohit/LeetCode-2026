package d_april

fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 1, 1),
            arrayOf(
                intArrayOf(0, 2, 1, 4)
            )
        )
    )

    testCases.forEach { (nums, queries) ->
        println("Result ==> ${xorAfterQueries1(nums, queries)}")
    }

}

// TC - O(q * n) : SC - O(1)
private fun xorAfterQueries1(nums: IntArray, queries: Array<IntArray>): Int {
    val mod = 1000000007
    for ((l, r, k, v) in queries) {
        for (i in l..r step k) {
            nums[i] = ((nums[i].toLong() * v) % mod).toInt()
        }
    }
    var res = 0
    for (num in nums) res = res xor num
    return res
}