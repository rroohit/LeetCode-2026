package e_may

fun main() {

    val testCases = listOf(
        "aaAbcBC", "abc", "abBCab"
    )

    testCases.forEach { word ->
        println("Result ==> ${numberOfSpecialChars(word)}")
    }

}

// TC - O(n) :: SC - O(26)
fun numberOfSpecialChars(word: String): Int {
    val lower = BooleanArray(26)
    val upper = BooleanArray(26)
    var count = 0

    for (ch in word) {
        if (ch.isLowerCase()) {
            lower[ch - 'a'] = true
        } else {
            upper[ch - 'A'] = true
        }
    }

    for (i in 0..25) if (lower[i] && upper[i]) count++

    return count
}
