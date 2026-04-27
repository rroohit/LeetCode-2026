package d_april

import java.util.*

fun main() {

    val testCases = listOf(
        arrayOf(
            charArrayOf('a', 'a', 'a', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'b', 'b', 'a')
        ),
        arrayOf(
            charArrayOf('a', 'b', 'b'),
            charArrayOf('b', 'z', 'b'),
            charArrayOf('b', 'b', 'a')
        )
    )

    testCases.forEach { grid ->
        val solution = SolutionApril26Two()
        println("Result ==> ${solution.containsCycle(grid)}")
    }

}

// BFS
// TC - O(m * n)
// SC - O(m * n)
class SolutionApril26Two {
    private lateinit var visited: Array<BooleanArray>
    private lateinit var grid: Array<CharArray>
    private var m = 0 // row size
    private var n = 0 // column size

    fun containsCycle(grid: Array<CharArray>): Boolean {
        this.m = grid.size
        this.n = grid[0].size
        this.visited = Array(m) { BooleanArray(n) { false } }
        this.grid = grid
        for (r in 0..<m) {
            for (c in 0..<n) {
                if (!visited[r][c] && bfs(r, c, grid[r][c])) return true
            }
        }
        return false
    }

    private fun bfs(rr: Int, cc: Int, char: Char): Boolean {
        val qu = LinkedList<Cell>()
        qu.offer(Cell(rr, cc, -1, -1))
        visited[rr][cc] = true

        while (qu.isNotEmpty()) {
            val (r, c, parR, parC) = qu.poll() ?: break

            // left
            if (c - 1 >= 0 && char == grid[r][c - 1]) {
                if (visited[r][c - 1]) {
                    if (r != parR || c - 1 != parC) return true
                } else {
                    visited[r][c - 1] = true
                    qu.offer(Cell(r, c - 1, r, c))
                }
            }

            // right
            if (c + 1 < n && char == grid[r][c + 1]) {
                if (visited[r][c + 1]) {
                    if (r != parR || c + 1 != parC) return true
                } else {
                    visited[r][c + 1] = true
                    qu.offer(Cell(r, c + 1, r, c))
                }
            }

            // up
            if (r - 1 >= 0 && char == grid[r - 1][c]) {
                if (visited[r - 1][c]) {
                    if (r - 1 != parR || c != parC) return true
                } else {
                    visited[r - 1][c] = true
                    qu.offer(Cell(r - 1, c, r, c))
                }
            }

            // down
            if (r + 1 < m && char == grid[r + 1][c]) {
                if (visited[r + 1][c]) {
                    if (r + 1 != parR || c != parC) return true
                } else {
                    visited[r + 1][c] = true
                    qu.offer(Cell(r + 1, c, r, c))
                }
            }
        }

        return false
    }

    private data class Cell(
        val r: Int,
        val c: Int,
        val parentR: Int,
        val parentC: Int
    )
}


//----------------------------------------------------------------------------------------------------------------------
// DFS
// TC - O(m * n)
// SC - O(m * n)
class SolutionApril26One {
    private lateinit var visited: Array<BooleanArray>
    private lateinit var grid: Array<CharArray>
    private var m = 0 // row size
    private var n = 0 // column size

    fun containsCycle(grid: Array<CharArray>): Boolean {
        this.m = grid.size
        this.n = grid[0].size
        this.visited = Array(m) { BooleanArray(n) { false } }
        this.grid = grid
        for (r in 0..<m) {
            for (c in 0..<n) {
                if (!visited[r][c] && dfs(r, c, -1, -1)) return true
            }
        }
        return false
    }

    // r = current cell row, c = current cell column
    // parR = current cell parent row, parC = current cell parent column
    // return - are we able to detect the cycle
    private fun dfs(r: Int, c: Int, parR: Int, parC: Int): Boolean {
        if (r < 0 || c < 0 || r == m || c == n) return false // base case our of the grid no cycle
        if (visited[r][c]) return false

        visited[r][c] = true
        val char = grid[r][c]

        // explore all four directions
        val left = if (c - 1 >= 0 && char == grid[r][c - 1]) {
            if (visited[r][c - 1]) {
                ((r != parR || c - 1 != parC))
            } else {
                dfs(r, c - 1, r, c)
            }
        } else false
        if (left) return true

        val right = if (c + 1 < n && char == grid[r][c + 1]) {
            if (visited[r][c + 1]) {
                (r != parR || c + 1 != parC)
            } else {
                dfs(r, c + 1, r, c)
            }
        } else false
        if (right) return true

        val up = if (r - 1 >= 0 && char == grid[r - 1][c]) {
            if (visited[r - 1][c]) {
                (r - 1 != parR || c != parC)
            } else {
                dfs(r - 1, c, r, c)
            }
        } else false
        if (up) return true

        // down
        return if (r + 1 < m && char == grid[r + 1][c]) {
            if (visited[r + 1][c]) {
                (r + 1 != parR || c != parC)
            } else {
                dfs(r + 1, c, r, c)
            }
        } else false
    }
}
//----------------------------------------------------------------------------------------------------------------------