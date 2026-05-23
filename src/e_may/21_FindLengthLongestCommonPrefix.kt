package e_may

fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1, 10, 100), intArrayOf(1000))
    )

    testCases.forEach { (arr1, arr2) ->
        println("Result ==> ${longestCommonPrefix(arr1, arr2)}")
    }

}

class SolutionMay21 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {

        return 0
    }

    data class Node(
        val curr: Int,
        val child: ArrayList<Node>
    )
}

//----------------------------------------------------------------------------------------------------------------------
// TC - O(d1^2 + d2^2) :: SC - O(d1^2)
// n = arr1.size
// m = arr2.size
// d1 = total number of digits across all numbers in arr1
// d2 = total number of digits across all numbers in arr2
fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val prefix = hashSetOf<String>()

    for (num in arr1) {
        val sb = StringBuilder()
        for (ch in num.toString()) {
            sb.append(ch)
            prefix.add(sb.toString())
        }
    }

    var len = 0
    for (num in arr2) {
        val sb = StringBuilder()
        for (ch in num.toString()) {
            sb.append(ch)
            val pref = sb.toString()
            if (prefix.contains(pref) && pref.length > len) {
                len = pref.length
            }
        }
    }

    return len
}
//----------------------------------------------------------------------------------------------------------------------