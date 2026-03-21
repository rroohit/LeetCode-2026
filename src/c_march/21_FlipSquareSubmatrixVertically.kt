package c_march

fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
                intArrayOf(13, 14, 15, 16)
            ),
            Triple(1, 0, 3)
        )
    )

    testCases.forEach { (grid, m) ->
        reverseSubmatrix(grid, m.first, m.second, m.third)
        for (ints in grid) {
            println(ints.toList())
        }
    }

}

// TC - O(k^2), SC - O(1)
fun reverseSubmatrix(grid: Array<IntArray>, x: Int, y: Int, k: Int): Array<IntArray> {
    for (c in y..<y + k) {
        var lr = x
        var rr = x + (k - 1)
        while (lr < rr) {
            val temp = grid[lr][c]
            grid[lr][c] = grid[rr][c]
            grid[rr][c] = temp
            lr++
            rr--
        }
    }
    return grid
}