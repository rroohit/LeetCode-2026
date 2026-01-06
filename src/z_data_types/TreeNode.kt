package z_data_types

class TreeNode(
    val `val`: Int
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Builds a binary tree from a level-order list.
 *
 * Example:
 * Input: [1, 2, 3, null, 4]
 * Tree:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 *
 * @param values Level-order list where null represents missing nodes
 * @return Root of the constructed binary tree
 */
fun buildTree(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    var i = 1
    while (i < values.size) {
        val curr = queue.removeFirst()

        // Left Child
        if (i < values.size && values[i] != null) {
            curr.left = TreeNode(values[i]!!)
            queue.add(curr.left!!)
        }
        i++

        // Right child
        if (i < values.size && values[i] != null) {
            curr.right = TreeNode(values[i]!!)
            queue.add(curr.right!!)
        }
        i++
    }

    return root
}

/**
 * Prints the inorder traversal of the binary tree.
 * Order: Left → Root → Right
 */
fun inorderPrint(root: TreeNode?) {
    if (root == null) return
    inorderPrint(root.left)
    print("${root.`val`} ")
    inorderPrint(root.right)
}

/**
 * Prints the preorder traversal of the binary tree.
 * Order: Root → Left → Right
 */
fun preorderPrint(root: TreeNode?) {
    if (root == null) return
    preorderPrint(root.left)
    preorderPrint(root.right)
    print("${root.`val`} ")
}

/**
 * Prints the postorder traversal of the binary tree.
 * Order: Left → Right → Root
 */
fun postorderPrint(root: TreeNode?) {
    if (root == null) return
    print("${root.`val`} ")
    postorderPrint(root.left)
    postorderPrint(root.right)
}


