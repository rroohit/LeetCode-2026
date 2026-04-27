package d_april

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(2, 4, 3),
            intArrayOf(6, 5, 2)
        )
    )

    testCases.forEach { grid ->
        val solution = SolutionApril27One()
        println("Result ==> ${solution.hasValidPath(grid)}")
    }

}

// DFS
// TC - O(m * n)
// SC - O(m * n)
class SolutionApril27One {
    private lateinit var grid: Array<IntArray>
    private lateinit var visited: Array<BooleanArray>
    private var m = 0 // row size
    private var n = 0 // column size

    fun hasValidPath(grid: Array<IntArray>): Boolean {
        this.grid = grid
        m = grid.size
        n = grid[0].size
        if (m == n && n == 1) return true
        this.visited = Array(m) { BooleanArray(n) { false } }
        return dfs(0, 0)
    }

    // r = current cell row 
    // c = current cell column
    // return if we can reach the bottom-right
    private fun dfs(r: Int, c: Int): Boolean {
        if (r == m - 1 && c == n - 1) return true
        if (visited[r][c]) return false

        val curr = grid[r][c]
        visited[r][c] = true

        return when (curr) {
            1 -> { // can go left and right cell
                canGoLeft(c, r) || canGoRight(c, r)
            }

            2 -> { // can go up and down cell
                canGoUp(r, c) || canGoDown(r, c)
            }

            3 -> { // can go left and down cell
                canGoLeft(c, r) || canGoDown(r, c)
            }

            4 -> { // can go right and down cell
                canGoRight(c, r) || canGoDown(r, c)
            }

            5 -> { // can go left and up cell
                canGoLeft(c, r) || canGoUp(r, c)
            }

            6 -> { // can go right and up cell
                canGoRight(c, r) || canGoUp(r, c)
            }

            else -> false // invalid direction of street
        }
    }

    private fun canGoDown(r: Int, c: Int): Boolean {
        val down = if (r + 1 < m) {
            val next = grid[r + 1][c]
            if ((next == 2 || next == 5 || next == 6)) {
                dfs(r + 1, c)
            } else false
        } else false
        return down
    }

    private fun canGoUp(r: Int, c: Int): Boolean {
        val up = if (r - 1 >= 0) {
            val next = grid[r - 1][c]
            if ((next == 2 || next == 3 || next == 4)) {
                dfs(r - 1, c)
            } else false
        } else false
        return up
    }

    private fun canGoRight(c: Int, r: Int): Boolean {
        val right = if (c + 1 < n) {
            val next = grid[r][c + 1]
            if ((next == 1 || next == 3 || next == 5)) {
                dfs(r, c + 1)
            } else false
        } else false
        return right
    }

    private fun canGoLeft(c: Int, r: Int): Boolean {
        val left = if (c - 1 >= 0) {
            val next = grid[r][c - 1]
            if ((next == 1 || next == 4 || next == 6)) {
                dfs(r, c - 1)
            } else false
        } else false
        return left
    }

}