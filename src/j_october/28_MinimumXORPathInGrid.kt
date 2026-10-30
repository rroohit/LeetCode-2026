package j_october

fun main() {


    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        ),
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
    )

    testCases.forEach { grid ->
        val solution = SolutionOct28c()
        println("Result ==> ${solution.minCost(grid)}")
    }

}

// DP - bottom-up
class SolutionOct28c {
    fun minCost(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
        dp[m][n - 1] = 0
        for (r in m - 1 downTo 0) {
            for (c in n - 1 downTo 0) {
                val curr = grid[r][c]
                val right = curr xor dp[r][c + 1]
                val down = curr xor dp[r + 1][c]
                dp[r][c] = minOf(dp[r][c],right, down)
            }
        }
        return dp[0][0]
    }
}

// DP - Recursion + Memoization (top-down)
class SolutionOct28b {
    private lateinit var grid: Array<IntArray>
    private var m = 0
    private var n = 0
    private val maxInt = Int.MAX_VALUE
    private lateinit var dp: Array<Array<IntArray>>

    fun minCost(grid: Array<IntArray>): Int {
        this.grid = grid
        this.m = grid.size
        this.n = grid[0].size
        this.dp = Array(m + 1) { Array(n + 1) { IntArray(2000) { -1 } } }
        return sol(0, 0, 0)
    }

    private fun sol(sr: Int, sc: Int, prev: Int): Int {
        if (sr >= m || sc >= n) return maxInt
        if (dp[sr][sc][prev] != -1) return dp[sr][sc][prev]
        val curr = grid[sr][sc]
        if (sr == m - 1 && sc == n - 1) return prev xor curr
        val right = sol(sr, sc + 1, prev xor curr)
        val down = sol(sr + 1, sc, prev xor curr)
        dp[sr][sc][prev] = minOf(right, down)
        return dp[sr][sc][prev]
    }
}

// TLE
// Recursion
// TC -
// SC -
class SolutionOct28a {
    private lateinit var grid: Array<IntArray>
    private var m = 0
    private var n = 0
    private val maxInt = Int.MAX_VALUE

    fun minCost(grid: Array<IntArray>): Int {
        this.grid = grid
        this.m = grid.size
        this.n = grid[0].size

        return sol(0, 0, 0)
    }

    private fun sol(sr: Int, sc: Int, prev: Int): Int {
        if (sr >= m || sc >= n) return maxInt
        val curr = grid[sr][sc] xor prev

        if (sr == m - 1 && sc == n - 1) return curr

        val right = sol(sr, sc + 1, curr)
        val down = sol(sr + 1, sc, curr)

        return minOf(right, down)
    }
}