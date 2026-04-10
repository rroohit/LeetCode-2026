package d_april

// Minimum Distance Between Three Equal Elements I
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 1, 1, 3),
        intArrayOf(1, 1, 2, 3, 2, 1, 2),
        intArrayOf(1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minimumDistance(nums)}")
    }

}

// TC - O(n) :: SC - O(u) - best case, O(n) - worst case :: u == unique elements.
fun minimumDistance(nums: IntArray): Int {
    val map = hashMapOf<Int, DistCal>()
    var dist = -1
    for (i in nums.indices) {
        val num = nums[i]
        if (map[num] == null) map[num] = DistCal(num)
        map[num]?.apply {
            addInd(i)
            if (isValidTriple()) {
                if (dist == -1 || getDist() < dist) dist = getDist()
            }
        }

    }
    return dist
}

private class DistCal(num: Int) {
    private var i = -1
    private var j = -1
    private var k = -1
    private var isValidTriple = false
    fun addInd(ind: Int) {
        when {
            (i == -1) -> i = ind
            (j == -1) -> j = ind
            (k == -1) -> k = ind
            else -> {
                i = j
                j = k
                k = ind
            }
        }
        isValidTriple = (k != -1)
    }

    fun isValidTriple() = isValidTriple

    fun getDist(): Int = (j - i) + (k - j) + (k - i)
}

fun minimumDistance3(nums: IntArray): Int {
    val map = hashMapOf<Int, ArrayList<Int>>()
    var dist = -1
    for (i in nums.indices) {
        val num = nums[i]
        if (map[num] == null) map[num] = ArrayList()
        map[num]?.add(i)
        val list = map[num] ?: arrayListOf()
        if (list.size > 2) {
            val k = list.size - 1
            val currDist = (list[k - 1] - list[k - 2]) + (list[k] - list[k - 1]) + (list[k] - list[k - 2])
            if (dist == -1 || currDist < dist) dist = currDist
        }
    }
    return dist
}

// TC - O(n) : SC - O(n)
fun minimumDistance2(nums: IntArray): Int {
    val map = hashMapOf<Int, ArrayList<Int>>()
    for (i in nums.indices) {
        val num = nums[i]
        if (map[num] == null) map[num] = ArrayList()
        map[num]?.add(i)
    }

    var dist = -1
    for ((num, list) in map) {
        if (list.size < 3) continue
        for (x in 2..<list.size) {
            val i = list[x - 2]
            val j = list[x - 1]
            val k = list[x]
            val currDis = (j - i) + (k - j) + (k - i)
            if (dist == -1 || currDis < dist) dist = currDis
        }
    }

    return dist
}


// TC - O(n^3) :: SC - O(n)
fun minimumDistance1(nums: IntArray): Int {
    val n = nums.size
    var dist = -1
    for (i in 0..<n) {
        val a = nums[i]
        for (j in i + 1..<n) {
            val b = nums[j]
            if (a != b) continue

            for (k in j + 1..<n) {
                val c = nums[k]
                if (c != b) continue

                val currDist = (j - i) + (k - j) + (k - i)
                if (dist == -1 || currDist < dist) dist = currDist
            }
        }
    }

    return dist
}