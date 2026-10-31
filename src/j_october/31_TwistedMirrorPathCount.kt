package j_october

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0)
        )
    )

    testCases.forEach { grid ->
        val solution = SolutionOct31c()
        println("Result ==> ${solution.uniquePaths(grid)}")
    }

}

class SolutionOct31c {
    private val mod = 1000000007
    fun uniquePaths(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m + 1) { Array(n + 1) { IntArray(2) } }
        dp[m - 1][n - 1][0] = 1
        dp[m - 1][n - 1][1] = 1
        for (r in m - 1 downTo 0) {
            for (c in n - 1 downTo 0) {
                if (r == m - 1 && c == n - 1) continue
                if (grid[r][c] == 0) {
                    dp[r][c][0] = (dp[r][c + 1][0] + dp[r + 1][c][1]) % mod
                    dp[r][c][1] = (dp[r][c + 1][0] + dp[r + 1][c][1]) % mod
                } else {
                    dp[r][c][0] = dp[r + 1][c][1] % mod

                    dp[r][c][1] = dp[r][c + 1][0] % mod
                }
            }
        }
        return (dp[0][1][0] + dp[1][0][1]) % mod
    }
}

// DP - Recursion + Memoization (top-down)
// TC - O(m * n)
// SC - O(m * n)
class SolutionOct31b {
    private val mod = 1000000007
    private lateinit var grid: Array<IntArray>
    private var m = 0
    private var n = 0
    private lateinit var dp: Array<Array<IntArray>>

    fun uniquePaths(grid: Array<IntArray>): Int {
        this.grid = grid
        this.m = grid.size
        this.n = grid[0].size
        dp = Array(m + 1) { Array(n + 1) { IntArray(2) { -1 } } }

        return (solve(0, 1, 0) + solve(1, 0, 1)) % mod
    }

    // d = direction :: 1 = down, 0 == right
    private fun solve(r: Int, c: Int, d: Int): Int {
        if (r >= m || c >= n) return 0
        if (r == m - 1 && c == n - 1) return 1
        if (dp[r][c][d] != -1) return dp[r][c][d]

        val curr = grid[r][c]
        dp[r][c][d] = if (curr == 1) {
            if (d == 0) {
                solve(r + 1, c, 1) % mod
            } else {
                solve(r, c + 1, 0) % mod
            }
        } else {
            val right = solve(r, c + 1, 0)
            val down = solve(r + 1, c, 1)
            (right + down) % mod
        }

        return dp[r][c][d]
    }
}

// BruteForce - Recursion
class SolutionOct31a {
    private val mod = 1000000007
    private lateinit var grid: Array<IntArray>
    private var m = 0
    private var n = 0

    fun uniquePaths(grid: Array<IntArray>): Int {
        this.grid = grid
        this.m = grid.size
        this.n = grid[0].size

        return (solve(0, 1, 0) + solve(1, 0, 1)) % mod
    }

    // d = direction :: 1 = down, 0 == right
    private fun solve(r: Int, c: Int, d: Int): Int {
        if (r >= m || c >= n) return 0
        if (r == m - 1 && c == n - 1) return 1

        val curr = grid[r][c]
        return if (curr == 1) {
            if (d == 0) {
                solve(r + 1, c, 1) % mod
            } else {
                solve(r, c + 1, 0) % mod
            }
        } else {
            val right = solve(r, c + 1, 0)
            val down = solve(r + 1, c, 1)
            (right + down) % mod
        }
    }
}