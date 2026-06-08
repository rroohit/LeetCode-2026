package f_june

fun main() {

    val testCases = listOf(
        Pair(intArrayOf(9, 12, 5, 10, 14, 3, 10), 10),
        Pair(intArrayOf(3, 4, 3, 2), 2)
    )

    testCases.forEach { (nums, pivot) ->
        println("Result ==> ${pivotArray(nums, pivot).toList()}")
    }

}

// TC - O(n) :: SC - O(1)
fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val n = nums.size
    val result = IntArray(n) { pivot }
    var i = 0
    for (num in nums) if (num < pivot) result[i++] = num

    i = n - 1
    for (j in n - 1 downTo 0) if (nums[j] > pivot) result[i--] = nums[j]

    return result
}

// TC - O(n) :: SC - O(n)
fun pivotArray1(nums: IntArray, pivot: Int): IntArray {
    val less = mutableListOf<Int>()
    val equal = mutableListOf<Int>()
    val greater = mutableListOf<Int>()

    for (num in nums) {
        when {
            num < pivot -> less.add(num)
            num > pivot -> greater.add(num)
            else -> equal.add(num)
        }
    }

    val result = IntArray(nums.size)
    var i = 0
    for (num in less) result[i++] = num
    for (num in equal) result[i++] = num
    for (num in greater) result[i++] = num

    return result
}