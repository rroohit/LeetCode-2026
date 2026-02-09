package b_february

import z_data_types.TreeNode
import z_data_types.buildTree
import z_data_types.inorderPrint

/**
 * Problem: 1382. Balance a Binary Search Tree.
 *
 *      Given the root of a Binary Search Tree (BST), return a balanced BST
 *      containing the same node values.
 *
 * ## Intuition -
 *
 *      Inorder traversal of a BST gives nodes in sorted order.
 *      If we store these nodes in an array and always pick the middle element
 *      as the root, we can rebuild a height-balanced BST.
 *
 * ## Approach -
 *
 *      1. Perform inorder traversal of the BST and store nodes in an array.
 *      2. Recursively build a balanced BST by choosing the middle element
 *          of the array/subarray as the root.
 *      3. Assign left and right subtrees using the same strategy.
 *
 * ## Complexity:
 *
 *   - Time complexity: O(n)
 *      (Each node is visited once during traversal and reconstruction)
 *
 *   - Space complexity: O(n)
 *      (Array to store nodes + recursion stack)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(1, null, 2, null, 3, null, 4, null, null)
    )

    testCases.forEach { values ->
        val root = buildTree(values)
        inorderPrint(root)
        println()
        val result = balanceBST(root)
        inorderPrint(result)
        println()
    }

}

private val arr = ArrayList<TreeNode?>()
fun balanceBST(root: TreeNode?): TreeNode? {
    buildArray(root)
    val newRoot = buildBst(0, arr.size - 1)
    return newRoot
}

private fun buildBst(l: Int, r: Int): TreeNode? {
    if (l > r) return null
    val midInd = (l + r) / 2
    val node = arr[midInd]
    node?.left = buildBst(l, midInd - 1)
    node?.right = buildBst(midInd + 1, r)
    return node
}

private fun buildArray(root: TreeNode?) {
    if (root == null) return
    buildArray(root.left)
    arr.add(root)
    buildArray(root.right)
}

