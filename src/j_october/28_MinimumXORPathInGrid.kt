package j_october

fun main() {


    println(12 xor 10)
    println(1 xor 3 xor 4)

}

// DP - Recursion + Memoization (top-down)
//
class SolutionOct28b {
    private lateinit var grid: Array<IntArray>
    private var m = 0
    private var n = 0
    private val maxIntg = Int.MAX_VALUE
    private lateinit var dp : Array<Array<IntArray>>

    fun minCost(grid: Array<IntArray>): Int {
        this.grid = grid
        this.m = grid.size
        this.n = grid[0].size
        this.dp = Array(m + 1) { Array(n + 1) { IntArray(2000) { -1 } } }

        return sol(0 ,0, 0)
    }

    private fun sol(sr: Int, sc: Int, prev: Int) : Int {
        if (sr >= m || sc >= n) return maxIntg
        if (dp[sr][sc][prev] != -1) return dp[sr][sc][prev]
        val curr = grid[sr][sc]

        if (sr == m - 1 && sc == n - 1) {
            return prev xor curr
        }

        val right =  sol(sr, sc + 1, prev xor curr)
        val down = sol(sr + 1, sc, prev xor curr)

        dp[sr][sc][prev] =  minOf(right, down)
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
        val curr = grid[sr][sc]

        if (sr == m - 1 && sc == n - 1) {
            return prev xor curr
        }

        val right = sol(sr, sc + 1, prev xor curr)
        val down = sol(sr + 1, sc, prev xor curr)

        return minOf(right, down)
    }
}