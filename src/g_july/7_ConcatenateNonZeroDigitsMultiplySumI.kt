package g_july

fun main() {

    val testCases = listOf(10203004, 1000)

    testCases.forEach { n ->
        println("Result ==> ${sumAndMultiply(n)}")
    }

}

// TC - O(logn) :: SC - O(1)
fun sumAndMultiply(n: Int): Long {
    var num = n
    var x = 0L
    var sum = 0L
    var place = 1L

    while (num > 0) {
        val dig = num % 10
        if (dig > 0) {
            x += dig * place
            place *= 10
        }
        sum += dig
        num /= 10
    }

    return sum * x
}