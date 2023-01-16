package leetcode.tree

import java.lang.Integer.max

fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    // leaf
    if (root.left == null && root.right == null) {
        return 1
    }

    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}