package a_january

/**
 *  Problem: 66. Plus One
 *
 *  Intuition:
 *      Start adding from the last digit. If it is less than 9, increment and finish.
 *      If it is 9, it becomes 0 and the carry moves left.
 *
 *  Approach:
 *      Traverse the array from right to left.
 *          - If a digit is less than 9, increment it and return.
 *          - Otherwise, set it to 0 and continue.
 *      If all digits are 9, create a new array with an extra leading 1.
 *
 *  Complexity:
 *      - Time Complexity: O(n)
 *      - Space Complexity: O(n) in the worst case, O(1) otherwise
 *
 *  Code:
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 3, 2, 1),
        intArrayOf(9)
    )

    testCases.forEach { digits ->
        println("Result ==> ${plusOne(digits).toList()}")
    }

}

// TC - O(n) :: SC - O(1) average , O(n) worst case.
fun plusOne(digits: IntArray): IntArray {
    val n = digits.size
    for (i in n - 1 downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }

    val result = IntArray(n + 1)
    result[0] = 1
    return result
}

// TC - O(n) :: SC - O(1) average , O(n) worst case.
fun plusOne1(digits: IntArray): IntArray {
    val n = digits.size
    var carry = 1
    for (i in n - 1 downTo 0) {
        val num = digits[i] + carry
        if (num >= 10) {
            digits[i] = 0
        } else {
            carry = 0
            digits[i] = num
            break
        }
    }

    return if (carry == 1) {
        intArrayOf(1).plus(digits)
    } else {
        digits
    }
}