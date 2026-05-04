package e_may

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)
        )
    )

    testCases.forEach { matrix ->
        rotate(matrix)
        println("Result ==> ${matrix.map { it.toList() }}")
    }

}

fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    for (l in 0..<n / 2) {
        for (i in l..<n - l - 1) {
            val a = C(l, i)
            val aV = matrix[a.r][a.c]

            val b = C(a.c, n - 1 - a.r)
            val bV = matrix[b.r][b.c]
            matrix[b.r][b.c] = aV

            val c = C(b.c, n - 1 - b.r)
            val cV = matrix[c.r][c.c]
            matrix[c.r][c.c] = bV

            val d = C(c.c, n - 1 - c.r)
            val dV = matrix[d.r][d.c]
            matrix[d.r][d.c] = cV

            matrix[a.r][a.c] = dV
        }
    }
}

private data class C(
    val r: Int,
    val c: Int
)