package c_march

fun main() {

    val testCases = listOf(
        Pair(1, 3),
        Pair(1, 4),
    )

    testCases.forEach { (n, k) ->
        println("Result ==> ${getHappyString(n, k)}")
        happyStrings.clear()
    }

}

private val happyStrings = ArrayList<String>()
fun getHappyString(n: Int, k: Int): String {
    buildHappyString("", n)
    return if (happyStrings.size < k) "" else happyStrings[k - 1]
}

private fun buildHappyString(curr: String, n: Int) {
    if (curr.length >= n) {
        happyStrings.add(curr)
        return
    }
    for (ch in listOf('a', 'b', 'c')) {
        val len = curr.length
        if (curr.isEmpty() || ch != curr[len - 1]) {
            buildHappyString(curr + ch, n)
        }
    }
}