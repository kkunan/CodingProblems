package leetcode

private fun isPalindrome(x: Int): Boolean {
    val chars = x.toString().toCharArray()
    chars.forEachIndexed { index, c ->
        if (chars[index] != chars[chars.size-(index+1)])
            return false
        if (index * 2 >= chars.size)
            return true
    }
    return true
}