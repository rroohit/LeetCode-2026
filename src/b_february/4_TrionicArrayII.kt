package b_february

// 3640. Trionic Array II.
fun main() {

    val testCases = listOf(
        intArrayOf(0, -2, -1, -3, 0, 2, -1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxSumTrionic(nums)}")
    }

}

fun maxSumTrionic(nums: IntArray): Long {

    return 0L
}