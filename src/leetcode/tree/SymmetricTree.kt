package leetcode.tree

// https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/627/
fun isSymmetric(root: TreeNode?): Boolean {
    // null
    if(root == null){
        return true
    }

    return triangularEqual(root.left, root.right)
}

private fun triangularEqual(left: TreeNode?, right: TreeNode?): Boolean{
    if(left == null && right == null){
        return true
    }

    // something not null
    if(right == null || left == null){
        return false
    }

    // both not null
    return left.`val` == right.`val`
            && triangularEqual(left.left, right.right)
            && triangularEqual(right.left, left.right)
}