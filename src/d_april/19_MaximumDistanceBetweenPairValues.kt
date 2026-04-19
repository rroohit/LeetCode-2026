package d_april

fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(55, 30, 5, 4, 2),
            intArrayOf(100, 20, 10, 10, 5)
        )
    )

    testCases.forEach { (nums1, nums2) ->
        println("Result ==> ${maxDistance(nums1, nums2)}")
    }

}

fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
    val n1 = nums1.size
    val n2 = nums2.size
    var l = 0
    var r = 0
    var maxDist = 0
    while (r < n2) {
        while (l < n1 && nums1[l] > nums2[r]) l++
        if (l == n1) break // there is no elements in nums1 who can less that nums2 numbers
        while (r < n2 && nums2[r] >= nums1[l]) r++
        maxDist = maxOf(maxDist, r - l - 1)
    }
    return maxDist
}

private class Solution1855 {
    private fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        val n1 = nums1.size
        val n2 = nums2.size
        var l = 0
        var maxDist = 0
        for (r in 0..<n2) {
            while (l < n1 && nums1[l] > nums2[r])
                l++
            if (l == n1) break
            maxDist = maxOf(maxDist, r - l)
        }
        return maxDist
    }
}


