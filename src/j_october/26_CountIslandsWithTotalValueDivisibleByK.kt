package j_october

fun main() {

    val testCases = listOf(
        Pair(
            5,
            arrayOf(
                intArrayOf(0, 2, 1, 0, 0),
                intArrayOf(0, 5, 0, 0, 5),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 1, 4, 7, 0),
                intArrayOf(0, 2, 0, 0, 8)
            )
        )
    )

    testCases.forEach { (k, grid) ->
        val solution = SolutionOct26()
        println("Result ==> ${solution.countIslands(grid, k)}")
    }


}

class SolutionOct26 {
    private lateinit var grid: Array<IntArray>

    fun countIslands(grid: Array<IntArray>, k: Int): Int {
        this.grid = grid
        val kk = k.toLong()
        var count = 0

        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] > 0) {
                    val sum = dfs(r, c)
                    if (sum % kk == 0L) count++
                }
            }
        }

        return count
    }

    // TC - O(m * n) :: SC - O(m * n)
    private fun dfs(sr: Int, sc: Int): Long {
        if (sr < 0 || sc < 0 || sr >= grid.size || sc >= grid[0].size) return 0L
        if (grid[sr][sc] == 0) return 0L
        val curr = grid[sr][sc]
        grid[sr][sc] = 0
        return curr + dfs(sr + 1, sc) + dfs(sr - 1, sc) + dfs(sr, sc + 1) + dfs(sr, sc - 1)
    }

    // TC - O(m * n) :: SC - O(m * n)
    private fun bfs(sr: Int, sc: Int): Long {
        val qu = ArrayDeque<Pair<Int, Int>>()
        val direction = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        var sum = 0L

        qu.addLast(Pair(sr, sc))
        sum += grid[sr][sc]
        grid[sr][sc] = 0

        while (qu.isNotEmpty()) {
            val (r, c) = qu.removeFirst()
            for ((dr, dc) in direction) {
                val nr = r + dr
                val nc = c + dc
                if (nr in grid.indices && nc in grid[0].indices && grid[nr][nc] > 0) {
                    sum += grid[nr][nc]
                    grid[nr][nc] = 0
                    qu.addLast(Pair(nr, nc))
                }
            }
        }

        return sum
    }
}