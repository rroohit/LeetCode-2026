package j_october

import java.util.PriorityQueue

fun main() {

    val testCases = listOf(
        InputData(
            n = 3,
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(1, 2, 1),
                intArrayOf(0, 2, 3)
            ),
            labels = "aab",
            k = 1
        )
    )

    testCases.forEach { (n, edges, labels, k) ->
        val solution = SolutionOct30()
        println("Result ==> ${solution.shortestPath(n, edges, labels, k)}")
    }


}

class SolutionOct30 {

    fun shortestPath(
        n: Int,
        edges: Array<IntArray>,
        labels: String,
        k: Int
    ): Int {
        val adjList = hashMapOf<Int, MutableList<Node>>()
        for ((u, v, w) in edges) {
            adjList.getOrPut(u) { mutableListOf() }
                .add(Node(v, w))
        }

        val dist = Array(n) {
            IntArray(k + 1) { Int.MAX_VALUE }
        }

        val pq = PriorityQueue<State>(
            compareBy { it.cost }
        )

        dist[0][1] = 0

        pq.offer(
            State(
                node = 0,
                count = 1,
                cost = 0
            )
        )

        while (pq.isNotEmpty()) {
            val current = pq.poll()
            val node = current.node
            val count = current.count
            val cost = current.cost

            if (cost != dist[node][count]) continue

            if (node == n - 1) return cost

            for ((node1, wt) in adjList[node] ?: emptyList()) {
                val newCount = if (labels[node] == labels[node1]) count + 1 else 1

                if (newCount > k) continue

                val newCost = cost + wt

                // Relaxation
                if (newCost < dist[node1][newCount]) {
                    dist[node1][newCount] = newCost
                    pq.offer(
                        State(
                            node = node1,
                            count = newCount,
                            cost = newCost
                        )
                    )
                }
            }
        }

        return -1
    }

    private data class Node(
        val node: Int,
        val wt: Int
    )

    private data class State(
        val node: Int,
        val count: Int,
        val cost: Int
    )
}



//--------------------//--------------------//--------------------//--------------------//--------------------//--------
private data class InputData(
    val n: Int,
    val edges: Array<IntArray>,
    val labels: String,
    val k: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputData

        if (n != other.n) return false
        if (k != other.k) return false
        if (!edges.contentDeepEquals(other.edges)) return false
        if (labels != other.labels) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n
        result = 31 * result + k
        result = 31 * result + edges.contentDeepHashCode()
        result = 31 * result + labels.hashCode()
        return result
    }
}