package f_june

import z_data_types.TreeNode
import z_data_types.inorderPrint

fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(20, 15, 1),
            intArrayOf(20, 17, 0),
            intArrayOf(50, 20, 1),
            intArrayOf(50, 80, 0),
            intArrayOf(80, 19, 1)
        ),
        arrayOf(
            intArrayOf(1, 2, 1), intArrayOf(2, 3, 0), intArrayOf(3, 4, 1)
        )
    )

    testCases.forEach { description ->
        val result = createBinaryTree(description)
        println("Result ==> ")
        inorderPrint(result)
        println()
    }

}

// TC - O(n) :: SC - O(n)
fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    val nodes = hashMapOf<Int, TreeNode>()
    val childs = hashSetOf<Int>()

    for ((p, c, l) in descriptions) {
        childs.add(c)
        val parentNode = nodes.getOrPut(p) { TreeNode(p) }
        val childNode = nodes.getOrPut(c) { TreeNode(c) }

        if (l == 1) parentNode.left = childNode else parentNode.right = childNode
    }

    for ((p, c, l) in descriptions) {
        if (!childs.contains(p)) return nodes[p]
    }

    return null
}

fun createBinaryTree1(descriptions: Array<IntArray>): TreeNode? {
    val nodes = hashMapOf<Int, TreeNode>()
    val childs = hashSetOf<Int>()

    for ((p, c, l) in descriptions) {
        childs.add(c)
        if (nodes[p] == null) nodes[p] = TreeNode(p)

        if (nodes[c] == null) nodes[c] = TreeNode(c)

        if (l == 1) {
            nodes[p]!!.left = nodes[c]
        } else {
            nodes[p]!!.right = nodes[c]
        }
    }

    for ((p, c, l) in descriptions) {
        if (!childs.contains(p)) return nodes[p]
    }

    return null
}
