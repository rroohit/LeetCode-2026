package b_february

/**
 *  Problem: 3010. Divide an Array Into Subarrays With Minimum Cost I.
 *
 *  ## Intuition -
 *      To minimize the total cost, we need the smallest possible sum of three elements.
 *      Since `nums[0]` must always be included, the task reduces to finding the two
 *          smallest elements from the remaining part of the array.
 *
 *  ## Approach -
 *      Iterate through the array starting from index 1 and keep track of the two
 *          smallest values (`first` and `sec`). Finally, add them to `nums[0]` to get
 *          the minimum cost.
 *
 *  ## Complexity:
 *       - Time complexity: O(n), single pass through the array.
 *
 *       - Space complexity: O(1), constant extra space.
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 12),
        intArrayOf(5, 4, 3),
        intArrayOf(10, 3, 1, 1),
        intArrayOf(1, 6, 49, 35, 41, 4, 31, 39, 36, 39)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minimumCost(nums)}")
    }

}

fun minimumCost(nums: IntArray): Int {
    var first = Int.MAX_VALUE
    var sec = first
    for (i in 1..<nums.size) {
        val num = nums[i]
        if (num < sec) {
            first = sec
            sec = num
        } else if (num < first) {
            first = num
        }
    }
    return nums[0] + first + sec
}