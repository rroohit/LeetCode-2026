package f_june

fun main() {

    val testCases = listOf(
        "nlaebolko", "loonbalxballpoon", "leetcode"
    )

    testCases.forEach { text ->
        println("Result ==> ${maxNumberOfBalloons(text)}")
    }

}

// TC - O(n) :: SC - O(1)
fun maxNumberOfBalloons(text: String): Int {
    var b = 0
    var a = 0
    var l = 0
    var o = 0
    var n = 0

    for (ch in text) {
        when (ch) {
            'b' -> b++
            'a' -> a++
            'l' -> l++
            'o' -> o++
            'n' -> n++
        }
    }
    l /= 2
    o /= 2

    return minOf(b, a, l, o, n)
}

fun maxNumberOfBalloons1(text: String): Int {
    val chCnt = hashMapOf('b' to 0, 'a' to 0, 'l' to 0, 'o' to 0, 'n' to 0)
    for (ch in text) {
        if (chCnt.containsKey(ch)) chCnt[ch] = chCnt[ch]!! + 1
    }

    chCnt['l'] = chCnt['l']!! / 2
    chCnt['o'] = chCnt['o']!! / 2

    var currCnt = Int.MAX_VALUE
    for ((ch, cnt) in chCnt) {
        if (cnt < currCnt) currCnt = cnt
    }

    return if (currCnt == Int.MAX_VALUE) 0 else currCnt
}