package j_october

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
            intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0)
        ),
        arrayOf(
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 1, 1, 1, 0)
        )
    )

    for (grid in testCases) {
        val solution = SolutionOct25()
        println("Result ==> ${solution.closedIsland(grid)}")
    }


}

//----------------------------------------------------------------------------------------------------------------------
// BFS :
// TC - O(r * c)
// SC - O(r * c)
class SolutionOct25 {
    fun closedIsland(grid: Array<IntArray>): Int {
        var count = 0
        for (r in grid.indices) {
            for (c in grid[r].indices) {
                if (grid[r][c] == 0 && bfs(r, c, grid)) count++
            }
        }
        return count
    }

    private fun bfs(sr: Int, sc: Int, grid: Array<IntArray>): Boolean {
        val rows = grid.size - 1
        val cols = grid[0].size - 1

        var isClosed = true
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(sr, sc))

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            if (r == 0 || c == 0 || r == rows || c == cols) isClosed = false

            val direction = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
            for ((dr, dc) in direction) {
                val nr = r + dr
                val nc = c + dc
                if (nr in 0..rows && nc in 0..cols && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1
                    queue.addLast(Pair(nr, nc))
                }
            }
        }

        return isClosed
    }
}

//----------------------------------------------------------------------------------------------------------------------


//----------------------------------------------------------------------------------------------------------------------
// DFS :
// TC - O(r * c)
// SC - O(r * c)
class SolutionOct25a {
    fun closedIsland(grid: Array<IntArray>): Int {
        var closed = 0
        for (r in grid.indices) {
            for (c in grid[r].indices) {
                if (grid[r][c] == 0 && dfs(r, c, grid)) closed++
            }
        }
        return closed
    }

    private fun dfs(r: Int, c: Int, grid: Array<IntArray>): Boolean {
        if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size) return false
        if (grid[r][c] == 1) return true
        grid[r][c] = 1
        val left = dfs(r, c - 1, grid)
        val right = dfs(r, c + 1, grid)
        val down = dfs(r + 1, c, grid)
        val up = dfs(r - 1, c, grid)
        return left && right && down && up
    }

}
//----------------------------------------------------------------------------------------------------------------------


