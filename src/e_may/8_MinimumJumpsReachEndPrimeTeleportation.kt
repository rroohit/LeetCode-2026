package e_may

fun main() {



}

class Solution {
    companion object {
        private const val MX = 1000001
        private val factors = Array(MX) { mutableListOf<Int>() }

        init {
            for (i in 2..<MX) {
                if (factors[i].isEmpty()) {
                    var j = i
                    while (j < MX) {
                        factors[j].add(i)
                        j += i
                    }
                }
            }
        }
    }

    fun minJumps(nums: IntArray): Int {
        val n = nums.size
        val edges = HashMap<Int, MutableList<Int>>()
        for (i in 0..<n) {
            for (p in factors[nums[i]]) {
                edges.getOrPut(p) { mutableListOf() }.add(i)
            }
        }

        var res = 0
        val seen = BooleanArray(n)
        seen[0] = true
        var q = mutableListOf(0)

        while (true) {
            val q2 = mutableListOf<Int>()
            for (i in q) {
                if (i == n - 1) return res
                if (i > 0 && !seen[i - 1]) {
                    seen[i - 1] = true
                    q2.add(i - 1)
                }
                if (i < n - 1 && !seen[i + 1]) {
                    seen[i + 1] = true
                    q2.add(i + 1)
                }
                if (factors[nums[i]].size == 1) {
                    val p = nums[i]
                    edges[p]?.let { list ->
                        for (j in list) {
                            if (!seen[j]) {
                                seen[j] = true
                                q2.add(j)
                            }
                        }
                        list.clear()
                    }
                }
            }
            q = q2
            res++
        }
    }
}