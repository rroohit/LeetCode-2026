package e_may

fun main() {

    val testCases = listOf(
        intArrayOf(4, 3, 2, 6),
        intArrayOf(100),
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxRotateFunction(nums)}")
    }

}

// TC - O(n) : SC - O(1)
private fun maxRotateFunction(nums: IntArray): Int {
    val n = nums.size
    var f = 0
    var sum = 0
    for (i in 0..<n) {
        val num = nums[i]
        f += (i * num)
        sum += num
    }
    var maxValue = f
    for (i in n - 1 downTo 1) {
        f += sum - n * nums[i]
        maxValue = maxOf(maxValue, f)
    }
    return maxValue
}
