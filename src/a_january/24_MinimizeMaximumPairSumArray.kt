package a_january

import kotlin.math.max

/**
 *  Problem: 1877. Minimize Maximum Pair Sum in Array.
 *
 *  ## Intuition -
 *      To minimize the maximum pair sum, pair the smallest number with the largest number.
 *      This balances large values and prevents any single pair from having an excessively large sum.
 *
 *  ## Approach -
 *      Sort the array, then use two pointers:
 *          one starting from the beginning (smallest) and one from the end (largest).
 *      Compute pair sums, track the maximum among them, and move pointers inward.
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n) due to sorting
 *       - Space complexity: O(1) extra space (in-place sort)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(3, 5, 2, 3),
        intArrayOf(3, 5, 4, 2, 4, 6),
        intArrayOf(4, 1, 5, 1, 2, 5, 1, 5, 5, 4)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minPairSum(nums)}")
    }

}

fun minPairSum(nums: IntArray): Int {
    nums.sort()
    var l = 0
    var r = nums.size - 1
    var maxSum = 0
    while (l < r) {
        maxSum = max(maxSum, nums[l] + nums[r])
        l++
        r--
    }
    return maxSum
}