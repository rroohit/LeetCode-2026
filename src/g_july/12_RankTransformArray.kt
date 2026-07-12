package g_july

fun main() {

    val testCases = listOf(
        intArrayOf(40, 10, 20, 30),
        intArrayOf(100, 100, 100),
        intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)
    )

    testCases.forEach { arr ->
        println("Result ==> ${arrayRankTransform(arr).toList()}")
    }

}

// TC - O(N log N) :: SC = O(N)
fun arrayRankTransform(arr: IntArray): IntArray {
    val sorted = arr.toSortedSet().toList()
    val ranks = hashMapOf<Int, Int>()
    for (i in sorted.indices) {
        if (ranks[sorted[i]] == null) ranks[sorted[i]] = i + 1
    }

    for (i in arr.indices) {
        arr[i] = ranks[arr[i]]!!
    }

    return arr
}

fun arrayRankTransform2(arr: IntArray): IntArray {
    val numInd = hashMapOf<Int, ArrayList<Int>>()
    for (i in arr.indices) {
        numInd.getOrPut(arr[i]) { arrayListOf() }.add(i)
    }
    val sorted = arr.toSortedSet().toList()
    for (i in sorted.indices) {
        numInd[sorted[i]]?.forEach {
            arr[it] = i + 1
        }
    }
    return arr
}


fun arrayRankTransform1(arr: IntArray): IntArray {
    val numInd = hashMapOf<Int, ArrayList<Int>>()
    for (i in arr.indices) {
        if (numInd[arr[i]] == null) numInd[arr[i]] = ArrayList()
        numInd[arr[i]]!!.add(i)
    }

    val sorted = numInd.toList().sortedBy { it.first }

    for (i in sorted.indices) {
        val (key, indx) = sorted[i]
        for (j in indx) arr[j] = i + 1
    }

    return arr
}
