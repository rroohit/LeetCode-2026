package e_may

fun main() {

    val testCases = listOf(3, 112, 144, 347)

    testCases.forEach { n ->
        println("Result ==> ${rotatedDigits(n)}")
    }

}

// TC - O(n logn) :: SC - O(1)
fun rotatedDigits(n: Int): Int {
    var total = 0
    for (num in 1..n) {
        if (isValid(num)) total++
    }
    return total
}

private fun isValid(n: Int): Boolean {
    var num = n
    var isValid = false
    while (num > 0) {
        val dig = num % 10
        if (dig == 3 || dig == 4 || dig == 7) return false
        if (dig == 2 || dig == 5 || dig == 6 || dig == 9) isValid = true
        num /= 10
    }
    return isValid
}