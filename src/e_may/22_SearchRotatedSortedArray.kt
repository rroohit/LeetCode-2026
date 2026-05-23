package e_may

fun main() {

    val testCases = listOf(
        Pair(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0),
        Pair(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3)
    )

    testCases.forEach { (nums, target) ->
        println("Result ==> ${search(nums, target)}")
    }

}

fun search(nums: IntArray, target: Int): Int {
    val n = nums.size
    var l = 0
    var r = n - 1

    while (l <= r) {
        val m = l + (r - l) / 2
        if (nums[m] == target) return m
        if (nums[m] >= nums[l]) {
            // left ... mid - sorted
            if (target in nums[l]..nums[m]) r = m - 1 else l = m + 1
        } else {
            // mid ... right - sorted
            if (target in nums[m]..nums[r]) l = m + 1 else r = m - 1
        }
    }

    return -1
}