package f_june

fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("abcd", "def", "xyz"),
            intArrayOf(5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2)
        ),
        Pair(
            arrayOf("a", "b", "c"),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        )
    )

    testCases.forEach { (words, weights) ->
        println("Result ==> ${mapWordWeights(words, weights)}")
    }

}

private val za = ('a'..'z').toList().reversed()
fun mapWordWeights(words: Array<String>, weights: IntArray): String {
    val sb = StringBuilder()

    for (word in words) {
        var totalWt = 0
        for (ch in word) totalWt += weights[ch - 'a']

        val chInd = totalWt % 26
        sb.append(za[chInd])
    }

    return sb.toString()
}