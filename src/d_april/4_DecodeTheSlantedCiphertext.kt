package d_april

// 2075. Decode the Slanted Ciphertext
fun main() {

    val testCases = listOf(
        Pair("ch   ie   pr", 3),
        Pair("iveo    eed   l te   olc", 4),
        Pair("coding", 1)
    )

    testCases.forEach { (encodedText, rows) ->
        println("Result ==> ${decodeCiphertext(encodedText, rows)}")
    }

}

// TC - O(n) :: SC - (r * c) (r = row , c = column)
fun decodeCiphertext(encodedText: String, rows: Int): String {
    val n = encodedText.length
    val col = n / rows
    val matrix = Array(rows) { CharArray(col) }

    var r = 0 // row index
    var c = 0 // col index

    for (ch in encodedText) {
        matrix[r][c++] = ch
        if (c >= col) {
            c = 0
            r++
        }
        if (r >= rows) break
    }

    val ans = StringBuilder()
    var startC = 0
    r = 0
    c = 0
    while (startC < col) {
        val curr = matrix[r++][c++]
        ans.append(curr)
        if (r >= rows || c >= col) {
            startC++
            c = startC
            r = 0
        }
    }

    return ans.toString().trimEnd()
}