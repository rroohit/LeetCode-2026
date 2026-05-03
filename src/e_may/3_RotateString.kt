package e_may

fun main() {

    val testCases = listOf(
        Pair("abcde", "cdeab"),
        Pair("abcde", "abced")
    )

    testCases.forEach { (s, goal) ->
        println("Result ==> ${rotateString(s, goal)}")
    }

}

// TC - O(n^2)
// SC - O(n)
fun rotateString(s: String, goal: String): Boolean {
    if (s.length != goal.length) return false
    val newGoal = goal + goal
    return newGoal.contains(s)
}

// TC - O(n^2)
// SC - O(1)
fun rotateStringOne(s: String, goal: String): Boolean {
    val n = s.length
    if (n != goal.length) return false
    for (i in s.indices) {
        if (s[i] == goal[0]) {
            var j = 0
            while (j < n) {
                val next = (i + j) % n
                if (goal[j] != s[next]) break
                j++
            }
            if (j == n) return true
        }
    }
    return false
}