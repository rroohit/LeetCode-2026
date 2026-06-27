package f_june

fun main() {

    val testCases = listOf(
        intArrayOf(5, 4, 1, 2, 2),
        intArrayOf(1, 3, 2, 4),
        intArrayOf(1, 1),
        intArrayOf(4, 36, 81, 16, 25)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maximumLength(nums)}")
    }

}

// TC - O(n log(max(nums))) :: O(n)
fun maximumLength(nums: IntArray): Int {
    val freq = hashMapOf<Long, Int>()
    for (num in nums) {
        val key = num.toLong()
        freq[key] = freq.getOrDefault(key, 0) + 1
    }

    val ones = freq[1] ?: 0
    var maxLen = 0
    if (ones > 0) {
        maxLen = if (ones % 2 == 0) ones - 1 else ones
    }

    for ((start, cnt) in freq) {
        if (start <= 1L) continue

        var level = 1
        var end = start
        while (freq[end]!! >= 2 && freq[end * end] != null) {
            level++
            end *= end
        }
        maxLen = maxOf(maxLen, 2 * level - 1)
    }

    return maxLen
}