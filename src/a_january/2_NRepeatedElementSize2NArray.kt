package a_january

/**
 *  Problem: 961. N-Repeated Element in Size 2N Array.
 *
 *  ## Intuition -
 *      Since exactly one element is repeated N times, the first duplicate
 *      encountered while traversing the array must be the answer.
 *
 *  ## Approach -
 *      Use a HashSet to keep track of visited elements.
 *      While iterating, try to add each number to the set.
 *      If adding fails, that number is already seen and is the repeated element.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 3),
        intArrayOf(2, 1, 2, 5, 3, 2),
        intArrayOf(5, 1, 5, 2, 5, 3, 5, 4)
    )

    testCases.forEach { nums ->
        println("Result ==> ${repeatedNTimes(nums)}")
    }

}

fun repeatedNTimes(nums: IntArray): Int {
    val seen = HashSet<Int>()
    for (num in nums) if (!seen.add(num)) return num
    return -1
}