package a_january

import z_data_types.TreeNode
import z_data_types.buildTree

/**
 * Problem: 1339. Maximum Product of Splitted Binary Tree.
 *
 * ## Intuition -
 *      Removing one edge always splits the tree into:
 *          1) a subtree
 *          2) the remaining part of the tree
 *
 *      If the total sum of the tree is TOTAL, and a subtree has sum S,
 *          then the product after splitting at that edge is:
 *          S × (TOTAL - S)
 *
 *      So the problem reduces to finding a subtree sum S that maximizes this expression.
 *
 * ## Approach -
 *      1. Use a DFS to compute the total sum of all nodes in the tree.
 *      2. Use a second postorder DFS to compute subtree sums.
 *      3. For every subtree, calculate the product:
 *        subtreeSum × (totalSum - subtreeSum)
 *          and keep track of the maximum value.
 *      4. Return the maximum product modulo 1e9 + 7.
 *
 *      Postorder traversal is used because a subtree’s sum depends on its children.
 *
 * ## Complexity:
 *      - Time complexity: O(n)
 *          - where n is the number of nodes in the tree.
 *              Each node is visited twice.
 *
 *      - Space complexity: O(h)
 *          - where h is the height of the tree due to the recursion stack.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(1, 2, 3, 4, 5, 6)
    )

    testCases.forEach { list ->
        val root = buildTree(list)
        println("Result ==> ${maxProduct(root)}")
    }

}

private var totalSum = 0L
private var maxProduct = 0L
private val MOD = 1000000007L

fun maxProduct(root: TreeNode?): Int {
    totalSum = computeTotalSum(root)
    dfs(root)
    return (maxProduct % MOD).toInt()
}

private fun dfs(root: TreeNode?): Long {
    if (root == null) return 0L
    val leftSum = dfs(root.left)
    val rightSum = dfs(root.right)
    val subTreeSum = leftSum + rightSum + root.`val`
    val product = subTreeSum * (totalSum - subTreeSum)
    maxProduct = maxOf(maxProduct, product)
    return subTreeSum
}

private fun computeTotalSum(root: TreeNode?): Long {
    if (root == null) return 0L
    return root.`val` + computeTotalSum(root.left) + computeTotalSum(root.right)
}