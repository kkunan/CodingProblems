package leetcode.tree

import java.lang.Integer.max

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
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
