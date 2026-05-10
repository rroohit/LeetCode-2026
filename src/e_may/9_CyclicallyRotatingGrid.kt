package e_may

fun main() {


}


fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
    val m = grid.size
    val n = grid[0].size
    val nLayer = minOf(m / 2, n / 2)

    // enumerate each layer counterclockwise starting from the top-left corner
    for (layer in 0..<nLayer) {

        val r = mutableListOf<Int>()
        val c = mutableListOf<Int>()
        val values = mutableListOf<Int>()

        // left
        for (i in layer..<m - layer - 1) {
            r.add(i)
            c.add(layer)
            values.add(grid[i][layer])
        }

        // down
        for (j in layer..<n - layer - 1) {
            r.add(m - layer - 1)
            c.add(j)
            values.add(grid[m - layer - 1][j])
        }

        // right
        for (i in m - layer - 1 downTo layer + 1) {
            r.add(i)
            c.add(n - layer - 1)
            values.add(grid[i][n - layer - 1])
        }

        // up
        for (j in n - layer - 1 downTo layer + 1) {
            r.add(layer)
            c.add(j)
            values.add(grid[layer][j])
        }

        val total = values.size
        val kk = k % total

        // place rotated values
        for (i in 0..<total) {
            val idx = (i + total - kk) % total
            grid[r[i]][c[i]] = values[idx]
        }
    }

    return grid
}
