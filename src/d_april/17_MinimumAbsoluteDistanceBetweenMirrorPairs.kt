package d_april

fun main() {

    val testCases = listOf(
        intArrayOf(12, 21, 45, 33, 54),
        intArrayOf(120, 21),
        intArrayOf(21, 120),
        intArrayOf(12, 453, 33, 54, 21)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minMirrorPairDistance(nums)}")
    }

}

// TC - O(n * m), m is longest length off the number
// SC - O(n)
fun minMirrorPairDistance(nums: IntArray): Int {
    val numInd = hashMapOf<Int, Int>()
    var minDist = -1
    for (i in nums.indices) {
        val num = nums[i]
        val revKey = reverse(num)
        if (numInd[num] != null) {
            val currDist = i - numInd[num]!!
            if (minDist == -1 || currDist < minDist) {
                minDist = currDist
            }
        }
        numInd[revKey] = i
    }
    return minDist
}

private fun reverse(num: Int): Int {
    var n = num
    var rev = 0
    while (n != 0) {
        val digit = n % 10
        rev = rev * 10 + digit
        n /= 10
    }
    return rev
}