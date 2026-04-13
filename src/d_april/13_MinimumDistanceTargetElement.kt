package d_april

import kotlin.math.abs

fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(1, 2, 3, 4, 5), 5, 3
        )
    )

    testCases.forEach { (nums, target, start) ->
        println("Result ==> ${getMinDistance(nums, target, start)}")
    }

}

// TC - O(n) :: SC - O(1)
fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
    var dist = nums.size
    for (i in nums.indices) {
        if (nums[i] != target) continue
        val x = abs(i - start)
        if (x < dist) dist = x
    }
    return dist
}