package g_july

fun main() {

    val testCases = listOf(
        Pair(
            4,
            arrayOf(
                intArrayOf(1, 2, 9),
                intArrayOf(2, 3, 6),
                intArrayOf(2, 4, 5),
                intArrayOf(1, 4, 7)
            )
        )
    )

    testCases.forEach { (n, roads) ->
        val solution = SolutionJuly4()
        println("Result ==> ${solution.minScore(n, roads)}")
    }

}

// TC - O(N + E) :: SC - O(N + E)
class SolutionJuly4 {
    private lateinit var adj: HashMap<Int, ArrayList<Node>>
    private lateinit var vis: BooleanArray
    private var ans = Int.MAX_VALUE

    fun minScore(n: Int, roads: Array<IntArray>): Int {
        this.adj = hashMapOf()
        for (edge in roads) {
            val (a, b, dist) = edge
            if (adj[a] == null) adj[a] = ArrayList()
            if (adj[b] == null) adj[b] = ArrayList()
            adj[a]!!.add(Node(b, dist))
            adj[b]!!.add(Node(a, dist))
        }

        this.vis = BooleanArray(n + 1)
        dfs(1)
        return ans
    }

    private fun dfs(curr: Int) {
        if (vis[curr]) return
        vis[curr] = true
        val list = adj[curr] ?: return
        for (neiNode in list) {
            ans = minOf(neiNode.wei, ans)
            if (!vis[neiNode.nei]) dfs(neiNode.nei)
        }
    }

    private data class Node(
        val nei: Int,
        val wei: Int
    )
}














