package b_february

// 3637. Trionic Array I.
fun main() {

    val testCases = listOf(
        intArrayOf(1, 3, 5, 4, 2, 6),
        intArrayOf(2, 1, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${isTrionic(nums)}")
    }

}

fun isTrionic(nums: IntArray): Boolean {
    val n = nums.size
    if (nums[0] >= nums[1]) return false
    var count = 1
    for (i in 2..<n) {
        if (nums[i - 1] == nums[i]) return false
        if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
            count++
        }
    }
    return count == 3
}