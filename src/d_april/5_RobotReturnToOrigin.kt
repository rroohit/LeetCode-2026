package d_april

// 657. Robot Return to Origin
fun main() {

    val testCases = listOf(
        "UD",
        "LL"
    )

    testCases.forEach { moves ->
        println("Result ==> ${judgeCircle(moves)}")
    }

}

// TC - O(n) : SC - O(1) :: n = length of the string 'moves'
fun judgeCircle(moves: String): Boolean {
    var startX = 0
    var startY = 0
    for (ch in moves) {
        when(ch) {
            'U' -> startY++
            'D' -> startY--
            'L' -> startX--
            'R' -> startX++
            else -> break
        }
    }
    return (startX == 0 && startY == 0)
}