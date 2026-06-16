package f_june

fun main() {

    val testCases = listOf(
        "a#b%*", "z*#"
    )

    testCases.forEach { s ->
        println("Result ==> ${processStr(s)}")
    }

}

// TC - O(n^2) :: SC - O(n)
fun processStr(s: String): String {
    var sb = StringBuilder()

    for (ch in s) {
        val len = sb.length
        when (ch) {
            '*' -> {
                if (len > 0) sb.deleteAt(len - 1)
            }

            '#' -> {
                for (i in 0..<len) sb.append(sb.get(i))
            }

            '%' -> {
                val newSb = StringBuilder()
                for (i in len - 1 downTo 0) newSb.append(sb.get(i))
                sb = newSb
            }

            else -> sb.append(ch)
        }
    }

    return sb.toString()
}
