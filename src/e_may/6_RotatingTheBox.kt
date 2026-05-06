package e_may

fun main() {

    val testCases = listOf(
        arrayOf(charArrayOf('#', '.', '#'))
    )

    testCases.forEach { boxGrid ->
        println("Result ==> ${rotateTheBox(boxGrid)}")
    }

}

// TC - O(m * n) :: SC - O(n * m)
fun rotateTheBox(boxGrid: Array<CharArray>): Array<CharArray> {
    val m = boxGrid.size // row -> column
    val n = boxGrid[0].size // column -> row
    val mat = Array(n) { CharArray(m) { '.' } }
    for (c in m - 1 downTo 0) {
        var r = n - 1
        for (l in r downTo 0) {
            if (boxGrid[m - 1 - c][l] == '#') {
                mat[l][c] = '.'
                mat[r--][c] = '#'
            }

            if (boxGrid[m - 1 - c][l] == '*') {
                r = l - 1
                mat[l][c] = '*'
            }
        }
    }
    return mat
}

// TC - O(m * n) :: SC - O(n * m)
fun rotateTheBox1(boxGrid: Array<CharArray>): Array<CharArray> {
    val m = boxGrid.size // row -> column
    val n = boxGrid[0].size // column -> row

    val mat = Array(n) { CharArray(m) { '.' } }

    for (r in n - 1 downTo 0) {
        for (c in m - 1 downTo 0) {
            mat[r][c] = boxGrid[m - 1 - c][r]
        }
    }

    for (c in m - 1 downTo 0) {
        var r = n - 1
        for (l in r downTo 0) {
            if (mat[l][c] == '#') {
                mat[l][c] = '.'
                mat[r--][c] = '#'
            }

            if (mat[l][c] == '*') {
                r = l - 1
            }
        }
    }

    return mat
}
