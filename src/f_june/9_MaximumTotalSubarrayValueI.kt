package f_june

fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1, 3, 2), 2),
        Pair(intArrayOf(4, 2, 5, 1), 3)
    )

    testCases.forEach { (nums, k) ->
        println("Result ==> ${maxTotalValue(nums, k)}")
    }

}

// TC - O(n) :: SC - O(1)
fun maxTotalValue(nums: IntArray, k: Int): Long {
    var maxNum = nums[0]
    var minNum = nums[0]
    for (num in nums) {
        if (num > maxNum) maxNum = num
        if (num < minNum) minNum = num
    }
    return k.toLong() * (maxNum - minNum)
}