package e_may

fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1, 2, 3), intArrayOf(2, 4)),
        Pair(intArrayOf(1, 2, 3, 6), intArrayOf(2, 3, 4, 5))
    )

    testCases.forEach { (nums1, nums2) ->
        println("Result ==> ${getCommon(nums1, nums2)}")
    }

}

// TC - O(n + m) :: SC - O(1)
fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    var l = 0
    var r = 0
    while (l < nums1.size && r < nums2.size) {
        if (nums1[l] == nums2[r]) return nums1[l]
        if (nums1[l] > nums2[r]) r++ else l++
    }
    return -1
}