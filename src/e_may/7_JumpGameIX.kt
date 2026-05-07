package e_may

fun main() {


}


data class Item(
    val value: Int,
    val left: Int,
    val right: Int
)

fun maxValue(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)

    val stack = mutableListOf<Item>()

    for (i in 0 until n) {
        var curr = Item(nums[i], i, i)

        while (stack.isNotEmpty() && stack.last().value > nums[i]) {
            val top = stack.removeAt(stack.lastIndex)

            curr = Item(
                maxOf(curr.value, top.value),
                top.left,
                curr.right
            )
        }

        stack.add(curr)
    }

    for (item in stack) {
        for (j in item.left..item.right) {
            ans[j] = item.value
        }
    }

    return ans
}
