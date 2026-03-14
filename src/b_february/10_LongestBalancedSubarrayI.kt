package b_february

// 3719. Longest Balanced Subarray I
fun main() {

    val testCases = listOf(
        intArrayOf(2, 5, 4, 3),
        intArrayOf(3, 2, 2, 5, 4),
        intArrayOf(1, 2, 3, 2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${longestBalanced(nums)}")
    }

}

fun longestBalanced(nums: IntArray): Int {


    return 0
}


// Brute force
// Problem:
// Find the length of the longest contiguous subarray where the count of
// distinct odd numbers equals the count of distinct even numbers.
//
// Intuition:
// A subarray is balanced when the number of unique odd and even elements is equal.
// Check all possible subarrays while tracking distinct odd and even values.
//
// Approach:
// Fix a starting index and expand the subarray to the right.
// Use two HashSets to store distinct odd and even numbers.
// When both sets have the same size, update the maximum length.
//
// Complexity:
// Time complexity: O(n²)
// Space complexity: O(n)
fun longestBalanced1(nums: IntArray): Int {
    var longest = 0
    for (i in nums.indices) {
        val odd = hashSetOf<Int>()
        val even = hashSetOf<Int>()
        for (j in i..<nums.size) {
            val num = nums[j]
            if (num and 1 == 0) even.add(num) else odd.add(num)
            val len = (j - i + 1)
            if (odd.size == even.size && len > longest) longest = len
        }
    }
    return longest
}