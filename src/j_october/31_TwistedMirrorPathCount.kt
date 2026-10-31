package j_october

fun main() {


}

// DP - Recursion + Memoization (top-down)
// TC - O(m * n)
// SC - O(m * n)
class SolutionOct31b {
    private val mod = 1000000007
    private lateinit var grid: Array<IntArray>
    private var m = 0
    private var n = 0
    private lateinit var dp : Array<Array<IntArray>>

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
                solve(r + 1, c, 1)  % mod
            } else {
                solve(r, c + 1, 0)  % mod
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