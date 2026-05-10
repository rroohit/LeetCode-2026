package e_may

import kotlin.math.abs

fun main() {


}

fun maximumJumps(nums: IntArray, target: Int): Int {
    val n = nums.size
    val dp = IntArray(n) { Int.MIN_VALUE }
    dp[0] = 0
    for (i in 1..<n) {
        for (j in 0..<i) {
            if (abs(nums[j] - nums[i]) <= target) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    return if (dp[n - 1] < 0) -1 else dp[n - 1]
}
