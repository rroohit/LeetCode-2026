package e_may

fun main() {


}

private val res = ArrayList<Int>()

fun separateDigits(nums: IntArray): IntArray {
    for (num in nums) {
        getDigits(num)
    }
    return res.toIntArray()
}

private fun getDigits(num: Int) {
    if (num < 1) return
    getDigits(num / 10)
    res.add(num % 10)
}