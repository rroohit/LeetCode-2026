package d_april

fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("word", "note", "ants", "wood"),
            arrayOf("wood", "joke", "moat")
        )
    )

    testCases.forEach { (queries, dictionary) ->
        println("Result ==> ${twoEditWords(queries, dictionary)}")
    }

}

//----------------------------------------------------------------------------------------------------------------------
// TC - O((D+Q)⋅L2)
// SC - O(D⋅L2+Q)
private val patterns = hashSetOf<String>()
fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
    val result = ArrayList<String>()

    if (queries[0].length <= 2) {
        for (word in queries) result.add(word)
        return result
    }

    for (word in dictionary) {
        for (pt in generatePattern(word)) {
            patterns.add(pt)
        }
    }

    for (word in queries) {
        for (pt in generatePattern(word)) {
            if (patterns.contains(pt)) {
                result.add(word)
                break
            }
        }
    }

    return result
}

private fun generatePattern(word: String): List<String> {
    val patterns = ArrayList<String>()
    val chars = word.toCharArray()
    for (i in 0..<word.length) {
        for (j in i + 1..<word.length) {
            val temp = chars.clone()
            temp[i] = '*'
            temp[j] = '*'
            patterns.add(String(temp))
        }
    }
    return patterns
}


//----------------------------------------------------------------------------------------------------------------------
// Brute force
// TC - O(Q * D * L) query word (Q) , dictionary word (D) , character (L length)
// SC - O(Q)
private fun twoEditWords1(queries: Array<String>, dictionary: Array<String>): List<String> {
    val result = ArrayList<String>()
    for (word1 in queries) {
        for (word2 in dictionary) {
            if (isValid(word1, word2)) {
                result.add(word1)
                break
            }
        }
    }
    return result
}

private fun isValid(word1: String, word2: String): Boolean {
    var diff = 2
    for (i in word1.indices) {
        if (word1[i] != word2[i]) {
            if (diff == 0) return false
            diff--
        }
    }
    return true
}

