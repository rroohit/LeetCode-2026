package d_april

fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(intArrayOf(0, 1), intArrayOf(2, 0)), 1
        ),
        Pair(
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), 1
        )
    )

    testCases.forEach { (grid, k) ->
        val solution = SolutionMaxPathScoreOne()
        println("Result ==> ${solution.maxPathScore(grid, k)}")
    }

}

// DP - Tabulation bottom-up
// TC - O(m * n * k)
// SC - O(m * n * k)
class SolutionMaxPathScoreTwo {
    private val minInf = Int.MIN_VALUE / 2
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m) { Array(n) { IntArray(k + 1) { minInf } } }
        dp[0][0][0] = 0

        for (r in 0..<m) {
            for (c in 0..<n) {
                for (kk in 0..k) {

                    val cellCost = if (grid[r][c] == 0) 0 else 1
                    val cellScore = grid[r][c]

                    if (kk < cellCost) continue

                    val prevCost = kk - cellCost

                    val top = if (r > 0) dp[r-1][c][prevCost] else minInf
                    val left = if (c > 0) dp[r][c-1][prevCost] else minInf

                    val best = maxOf(top, left)

                    if (best != minInf) {
                        dp[r][c][kk] = maxOf(dp[r][c][kk], best + cellScore)
                    }
                }
            }
        }

        var ans = minInf
        for (kk in 0..k) {
            ans = maxOf(ans, dp[m-1][n-1][kk])
        }

        return if (ans == minInf) -1 else ans
    }
}

//----------------------------------------------------------------------------------------------------------------------
// DP - Recursive + Memoization top down
// TC - O(m * n * k)
// SC - O(m * n * k)
private class SolutionMaxPathScoreOne {
    private val minInf = Int.MIN_VALUE
    private lateinit var grid: Array<IntArray>
    private var m = 0 // row size
    private var n = 0 // col size

    private lateinit var dp: Array<Array<IntArray>>

    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        this.grid = grid
        m = grid.size
        n = grid[0].size

        this.dp = Array(m) { Array(n) { IntArray(k + 1) { -1 } } }

        val score = solve(0, 0, k)
        return if (score < 0) -1 else score
    }

    private fun solve(r: Int, c: Int, k: Int): Int {
        if (r >= m || c >= n || k < 0) return minInf // base case
        if (dp[r][c][k] != -1) return dp[r][c][k]

        val cellValue = grid[r][c]
        val kk = if (cellValue > 0) k - 1 else k

        if (r == m - 1 && c == n - 1) {
            return if (kk >= 0) cellValue else minInf
        }

        val right = solve(r, c + 1, kk)
        val down = solve(r + 1, c, kk)

        val best = maxOf(right, down)

        dp[r][c][k] = if (best == minInf) minInf else best + cellValue
        return dp[r][c][k]
    }
}
//----------------------------------------------------------------------------------------------------------------------