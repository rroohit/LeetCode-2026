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

// TC - O(n) :: SC - O(n)
fun pivotArray(nums: IntArray, pivot: Int): IntArray {
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