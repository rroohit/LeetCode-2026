package a_january

/**
 *  Problem: 1390. Four Divisors.
 *
 *  ## Intuition -
 *      A number can have exactly four divisors only if:
 *          - It is a product of two distinct primes (p × q), or
 *          - It is a cube of a prime (p³).
 *      We can detect this by counting divisors efficiently up to √n.
 *
 *  ## Approach -
 *      For each number:
 *          - Iterate from 1 to √n and count divisors in pairs (i, n / i).
 *          - Maintain divisor count and sum.
 *          - Stop early if divisor count exceeds 4.
 *          - Add the divisor sum only if count is exactly 4.
 *
 *  ## Complexity:
 *       - Time complexity: O(n · √m)
 *          - where m is the maximum value in nums
 *       - Space complexity: O(1)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(21, 4, 7),
        intArrayOf(21, 21),
        intArrayOf(1, 2, 3, 4, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${sumFourDivisors(nums)}")
    }

}

fun sumFourDivisors(nums: IntArray): Int {
    var sum = 0
    for (num in nums) {
        sum += getFourSum(num)
    }
    return sum
}

private fun getFourSum(n: Int): Int {
    var divFreq = 0
    var sum = 0
    for (i in 1..getSqrt(n)) {
        if (n % i == 0) {
            val next = n / i
            if (next == i) {
                divFreq++
                sum += i
            } else {
                divFreq += 2
                sum += next + i
            }
        }
        if (divFreq > 4) break
    }
    return if (divFreq == 4) sum else 0
}

private fun getSqrt(n: Int): Int {
    if (n < 2) return n
    var l = 0
    var r = n
    var res = 0
    while (l < r) {
        val m = l + (r - l) / 2
        if (m <= n / m) {
            res = m
            l = m + 1
        } else {
            r = m - 1
        }
    }
    return res
}