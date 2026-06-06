package f_june

import kotlin.math.abs

fun main() {

    val testCases = listOf(
        intArrayOf(10, 4, 8, 3),
        intArrayOf(1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${leftRightDifference(nums).toList()}")
    }

}

fun leftRightDifference(nums: IntArray): IntArray {
    var right = 0
    for (num in nums) right += num
    var left = 0
    for (i in nums.indices) {
        val curr = nums[i]
        left += curr
        nums[i] = abs(right - left)
        right -= curr
    }
    return nums
}
