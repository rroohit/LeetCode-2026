package c_march

fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(
                intArrayOf(7, 6, 3),
                intArrayOf(6, 6, 1)
            ),
            18
        ),
        Pair(
            arrayOf(
                intArrayOf(7, 2, 9),
                intArrayOf(1, 5, 0),
                intArrayOf(2, 6, 6)
            ),
            20
        )
    )

    testCases.forEach { (grid, k) ->
        println("Result ==> ${countSubmatrices(grid, k)}")
    }

}

fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
    val m = grid.size
    val n = grid[0].size
    var count = 0
    for (i in 0..<m) {
        for (j in 0..<n) {
            if (i > 0) grid[i][j] += grid[i - 1][j]
            if (j > 0) grid[i][j] += grid[i][j - 1]
            if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1]
            if (grid[i][j] <= k) count++
        }
    }
    return count
}