package a_january

import z_data_types.TreeNode
import z_data_types.buildTree
import z_data_types.inorderPrint
import java.util.LinkedList

/**
 * Problem: 1161. Maximum Level Sum of a Binary Tree.
 *
 * ## Intuition -
 *      Each level’s sum is independent, so we process the tree level by level and
 *      keep track of the maximum sum encountered so far.
 *
 * ## Approach -
 *      Use Breadth-First Search (level-order traversal) with a queue.
 *      For each level, compute the sum of all nodes at that level and update the
 *          maximum sum and corresponding level if needed.
 *
 * ## Complexity:
 *      - Time complexity: O(n)
 *          where n is the number of nodes.
 *
 *      - Space complexity: O(w)
 *          where w is the maximum width of the tree.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(1, 7, 0, 7, -8, null, null)
    )

    testCases.forEach { list ->
        val root = buildTree(list)
        inorderPrint(root)
        println()
        println("Result ==> ${maxLevelSum(root)}")
    }

}

fun maxLevelSum(root: TreeNode?): Int {
    if (root == null) return 0
    var level = 1
    var maxLevel = 1
    var maxSum = root.`val`
    val qu = LinkedList<TreeNode?>()
    qu.offer(root)
    while (qu.isNotEmpty()) {
        val size = qu.size
        var currSum = 0
        repeat(size) {
            val currNode = qu.poll() ?: return@repeat
            currSum += currNode.`val`
            if (currNode.left != null) qu.offer(currNode.left)
            if (currNode.right != null) qu.offer(currNode.right)
        }
        if (currSum > maxSum) {
            maxLevel = level
            maxSum = currSum
        }
        level++
    }
    return maxLevel
}
